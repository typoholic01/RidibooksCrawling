package web.db.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.db.service.FileService;
import web.db.service.PostService;
import web.db.vo.File;
import web.db.vo.Post;
import web.db.vo.User;
import web.query.vo.QueryPost;
import web.view.util.FileUpload;
import web.view.util.Pagination;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//http://springboot.tistory.com/25 예외처리
	
	@Autowired
	PostService postServ;
	
	@Autowired
	FileService fileServ;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/{boardUrl}/write",method=RequestMethod.GET)
	public String write(@PathVariable String boardUrl, HttpServletRequest req) {
		logger.info("/{}/write",boardUrl);
		
		//init
		HttpSession session;
		User login;
		
		session = req.getSession();
		
		login = (User) session.getAttribute("login");
		
		if (login == null) {
			return "errorLogin.tiles";
		} else {
			return "write.tiles";			
		}
		
		
	}
	
	//글쓰기 기능
	@RequestMapping(value="/{boardUrl}/write",method=RequestMethod.POST)
	public String writePost(@PathVariable String boardUrl, Post post, Model model) throws IOException {
		logger.info("Post: /{}/write",boardUrl);
		//init
		
		//setup
		post.setBoardUrl(boardUrl);
		
		logger.info(post.toString());
        
		//run
		postServ.insertPost(post, null);
		
		logger.info("insert Done");
		
		return "redirect:/"+boardUrl;
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//JSON리스트
	@RequestMapping(value="/json/{boardUrl}",method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Post> jsonList(@PathVariable String boardUrl, HttpServletRequest req) {
		logger.info("/json/{}",boardUrl);

		//init
		List<Post> postList;
		QueryPost query;
		Pagination pagination;
		
		//페이징
		pagination = new Pagination(getTotalPost(boardUrl), getParam(req, "page"));

		//질의 설정
		query = new QueryPost();
		query.setBoardUrl(boardUrl);
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		query.setArticleLimit(pagination.getArticleLimit());
		
		//받아오기
		postList = postServ.getPostList(query);
		
		return postList;
	}
	//리스트 화면
	@RequestMapping(value="/{boardUrl}",method=RequestMethod.GET, produces="text/html")
	public String list(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("/{}",boardUrl);

		//init
		List<Post> postList;
		QueryPost query;
		Pagination pagination;
		String boardName;
		
		//페이징
		pagination = new Pagination(getTotalPost(boardUrl), getParam(req, "page"));

		//질의 설정
		query = new QueryPost();
		query.setBoardUrl(boardUrl);
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		query.setArticleLimit(pagination.getArticleLimit());
		
		//받아오기
		postList = postServ.getPostList(query);
		
		//이름 설정
		if (boardUrl.equals("free")) {
			boardName = "자유 게시판";
		} else {
			boardName = "뉴스 게시판";			
		}
		
		//요소 추가
		model.addAttribute("postList", postList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardName", boardName);
		
		return "board.tiles";
	}

	//디테일 화면
	@RequestMapping(value="/{boardUrl}/{postSeq}",method=RequestMethod.GET, produces="text/html")
	public String detail(@PathVariable String boardUrl, @PathVariable int postSeq, HttpServletRequest req, Model model) {
		logger.info("/{}/{}", boardUrl, postSeq);
		//init
		Pagination pagination;
		List<Post> bbsList;
		Post post;
		QueryPost query;
		List<File> fileList;

		//페이징
		pagination = new Pagination(getTotalPost(boardUrl), getParam(req,"page"));
		fileList = new ArrayList<>();
		
		query = new QueryPost();
		query.setBoardUrl(boardUrl);
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		query.setArticleLimit(pagination.getArticleLimit());
		
		//DB 데이터
		post = postServ.getPost(postSeq);
		bbsList = postServ.getPostList(query);
		fileList = fileServ.getFileList(postSeq);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("post", post);
		model.addAttribute("fileList", fileList);

		return "detail.tiles";
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value="/{boardUrl}/{postSeq}/update",method=RequestMethod.GET)
	public String updatePostView(@PathVariable String boardUrl, @PathVariable int postSeq, HttpServletRequest req, Model model) {
		logger.info("진입");
		//init
		Post post;
		
		//DB get
		post = postServ.getPost(postSeq);
		
		//요소 추가
		model.addAttribute("post", post);
		
		return "update.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value="/{boardUrl}/{postSeq}",method=RequestMethod.PUT)
	public String updatePost(@PathVariable String boardUrl, @PathVariable int postSeq, Post post, HttpServletRequest req) {
		logger.info("진입");

		//init
		User user;
		String userId;
		
		//query Set
		post.setBoardUrl(boardUrl);
		post.setSeq(postSeq);		
		
		//아이디 확인
		user = (User) req.getSession().getAttribute("login");
		userId = postServ.getPostUserId(postSeq);
		
		if (user != null && userId.equals(user.getEmail()) == true) {
			//수정
			postServ.updatePost(post);		
		}
		
		return  "redirect:/"+boardUrl;
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/{boardUrl}/{postSeq}",method=RequestMethod.DELETE)
	public String deletePost(@PathVariable String boardUrl, @PathVariable int postSeq, HttpServletRequest req, RedirectAttributes redirectAttributes) {
		logger.info("진입");
		
		//init
		User user;
		String userId;
		
		//아이디 확인
		user = (User) req.getSession().getAttribute("login");
		userId = postServ.getPostUserId(postSeq);
		
		if (user != null && userId.equals(user.getEmail()) == true) {
			//삭제
			postServ.deletePost(postSeq);			
		}
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", req.getParameter("page"));
		
		return "redirect:/"+boardUrl;				
		
	}	
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
	private int getParam(HttpServletRequest req, String param) {
		int currPage;
		
		if (req.getParameter(param) == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(req.getParameter(param));
		}
		
		return currPage;
	}

	private int getTotalPost(String boardUrl) {
		return postServ.getTotalPost(boardUrl);
	}

}