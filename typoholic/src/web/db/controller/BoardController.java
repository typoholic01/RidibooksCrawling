package web.db.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.db.service.PostService;
import web.db.vo.Post;
import web.db.vo.QueryPost;
import web.view.util.FileUpload;
import web.view.util.Pagination;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//http://springboot.tistory.com/25 예외처리
	
	@Autowired
	PostService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/{boardSeq}/write.do",method=RequestMethod.GET)
	public String write(@PathVariable int boardSeq, Model model) {
		logger.info("/{}/write.do",boardSeq);
		
		
		
		return "mainBbsWrite.tiles";
	}
	
	//글쓰기 기능
	@RequestMapping(value="/{boardSeq}/writeAf.do",method=RequestMethod.POST)
	public String writePost(@PathVariable int boardSeq, MultipartHttpServletRequest req, MultipartFile uploadFile, Model model) throws IOException {
		logger.info("Post: /{}/writeAf.do",boardSeq);
		//init
		String path = "";
        String userId;
        String title;
        String content;
        
        //init
        path = req.getSession().getServletContext().getRealPath("/") + "upload/file/"; //파일 저장경로
        web.view.util.FileUpload fileUpload = new FileUpload(uploadFile, path);
        Post post = new Post();
        
        //listen
		userId = req.getParameter("userId");
		title = req.getParameter("bbsTitle");
		content = req.getParameter("bbsContent");
		
		//setup
		post.setBoardSeq(boardSeq);
		post.setUserId(userId);
		post.setTitle(title);
		post.setContent(content);
        
		serv.insertPost(post);
		
		logger.info("insert Done");
		
		return "redirect:/"+boardSeq+"/list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value="/{boardSeq}/list.do",method=RequestMethod.GET)
	public String list(@PathVariable int boardSeq, HttpServletRequest req, Model model) {
		logger.info("/bbs/list.do");
		
		//init
		List<Post> bbsList;
		QueryPost query;
		Pagination pagination;
		
		//페이징
		pagination = new Pagination(getTotalPost(boardSeq), getCurrPage(req));

		//질의 설정
		query = new QueryPost();
		query.setBoardSeq(boardSeq);
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		
		//받아오기
		bbsList = serv.getPostList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardSeq", boardSeq);
		
		return "mainBbsList.tiles";
	}

	//디테일 화면
	@RequestMapping(value="/{boardSeq}/detail.do",method=RequestMethod.GET)
	public String detail(@PathVariable int boardSeq, HttpServletRequest req, Model model) {
		logger.info("/{}/detail.do", boardSeq);
		//init
		Pagination pagination;
		List<Post> bbsList;
		Post bbs;
		QueryPost query;
		int postSeq;

		//페이징
		pagination = new Pagination(getTotalPost(boardSeq), getCurrPage(req));
		
		//질의 설정
		postSeq = Integer.parseInt(req.getParameter("seq"));
		
		query = new QueryPost();
		query.setBoardSeq(boardSeq);
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		
		//DB 데이터
		bbs = serv.getPost(postSeq);
		bbsList = serv.getPostList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardSeq", boardSeq);
		model.addAttribute("bbs", bbs);
		
//		//매핑
//		if (boardUrl.equals("notice")) {
//			logger.info("noReply");
//			//댓글 없는 곳
//			return "noReplyDetail.tiles";
//			
//		} else {
//			logger.info("Reply");
//			//댓글 있는 곳
//			return "mainBbsDetail.tiles";
//		}

		return "mainBbsDetail.tiles";
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value="/{boardSeq}/update.do",method=RequestMethod.GET)
	public String updateArticle(@PathVariable int boardSeq, HttpServletRequest req, Model model) {
		logger.info("bbs/update");
		//init
		Post bbs;
		
		//DB get
		bbs = serv.getPost(getSeq(req));
		
		//요소 추가
		model.addAttribute("bbs", bbs);
		
		return "mainBbsUpdate.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value="/{boardSeq}/updateAf.do",method=RequestMethod.POST)
	public String updateAfArticle(@PathVariable int boardSeq, Post post, Model model) {
		logger.info("updateAfArticle");
		
		//query Set
		post.setBoardSeq(boardSeq);
		
		//DB set
		try {
			serv.updatePost(post);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return  "redirect:/"+boardSeq+"/list.do";
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/{boardSeq}/delete.do",method=RequestMethod.GET)
	public String deleteArticle(@PathVariable int boardSeq, HttpServletRequest req, RedirectAttributes redirectAttributes) {
		logger.info("/bbs/delete");
		
		//삭제
		serv.deletePost(getSeq(req));
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", req.getParameter("page"));
		
		return "redirect:/"+boardSeq+"/list.do";
		
	}
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
	private int getCurrPage(HttpServletRequest req) {
		int currPage;
		
		if (req.getParameter("page") == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(req.getParameter("page"));
		}
		
		return currPage;
	}
	
	private int getSeq(HttpServletRequest req) {
		int seq;
		
		if (req.getParameter("seq") == null) {
			seq = 0;
		} else {
			seq = Integer.parseInt(req.getParameter("seq"));
		}
		
		return seq;
	}

	private int getTotalPost(int boardSeq) {
		return serv.getTotalPost(boardSeq);
	}

}