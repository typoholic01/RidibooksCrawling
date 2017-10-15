package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.CommentDao;
import web.db.vo.Comment;
import web.query.vo.QueryComment;

@Service
@Transactional
public class CommentService {
	private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
	
	@Autowired
	CommentDao dao;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/

	public boolean insertComment(Comment comment) {
		logger.info("진입");
		
		return dao.insertComment(comment);
	} 


	/*************************************************
	 * 					READ
	 * ***********************************************/	

	public int getTotalComment(int postSeq) {
		logger.info("진입");
		
		return dao.getTotalComment(postSeq);
	} 

	public Comment getComment(int commentSeq) {
		logger.info("진입");
		
		return dao.getComment(commentSeq);
	} 
	
	public List<Comment> getCommentList(QueryComment query) {
		logger.info("진입");
		
		return dao.getCommentList(query);
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	public boolean updateComment(Comment comment) {
		logger.info("진입");
		
		return dao.updateComment(comment);
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deleteComment(int commentSeq) {
		logger.info("진입");
		
		return dao.deleteComment(commentSeq);
	}

}
