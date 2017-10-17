package web.db.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import web.db.service.CommentService;
import web.db.vo.Comment;
import web.db.vo.File;
import web.db.vo.Post;
import web.query.vo.QueryComment;
import web.view.util.FileUpload;
import web.view.util.Pagination;

@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService serv;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/	
	//글쓰기 기능
	@RequestMapping(value="/{boardUrl}/{postSeq}/comment",method=RequestMethod.POST)
	public @ResponseBody boolean writeComment(@PathVariable int postSeq, Comment comment) {
		logger.info("진입");
		//init
		
        //action
		serv.insertComment(comment);		
		
		return true;
	}
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//[AJAX] 리스트 화면
	@RequestMapping(value="/{boardUrl}/{postSeq}/comment",method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Map<String, Object> list(@PathVariable int postSeq, HttpServletRequest req) {
		logger.info("진입");
		
		//init
		Map<String, Object> map;
		List<Comment> commentList;
		QueryComment queryComment;
		Pagination pagination;
		
		//init2
		map = new HashMap<>();
				
		//페이징
		pagination = new Pagination(getTotalComment(postSeq), getCurrPage(req));			

		//질의 설정
		queryComment = new QueryComment();
		queryComment.setPostSeq(postSeq);
		queryComment.setStartArticle(pagination.getStartArticle());
		queryComment.setArticleLimit(pagination.getArticleLimit());
		
		//받아오기
		commentList = serv.getCommentList(queryComment);
		
		//요소 추가
		map.put("commentList", commentList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/	
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글쓰기 기능
	@RequestMapping(value="/{boardUrl}/{postSeq}/comment/{commentSeq}",method=RequestMethod.DELETE)
	public @ResponseBody boolean deleteComment(@PathVariable int commentSeq, Comment comment) {
		logger.info("진입");
		//init
		
        //action
		serv.deleteComment(commentSeq);
		
		return true;
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

	private int getTotalComment(int postSeq) {
		return serv.getTotalComment(postSeq);
	}
}
