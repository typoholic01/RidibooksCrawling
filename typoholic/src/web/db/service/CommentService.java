package web.db.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import web.db.dao.ArticleDao;
import web.db.dao.CommentDao;
import web.db.dao.RidibookDao;
import web.db.vo.Article;
import web.db.vo.Comment;
import web.db.vo.QueryArticle;
import web.db.vo.QueryComment;
import web.db.vo.Ridibook;
import web.view.util.Pagination;

public class CommentService {
	private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
	
	@Autowired
	SqlSession session;	
	
	CommentDao dao = session.getMapper(CommentDao.class);

	/*************************************************
	 * 					CREATE
	 * ***********************************************/


	public boolean insertComment(Comment comment) {
		logger.info("진입");
		return dao.insertComment(comment);		
	}; 




	/*************************************************
	 * 					READ
	 * ***********************************************/
	public Comment getComment(int commentSeq) {
		logger.info("진입");
		return dao.getComment(commentSeq);
		
	}
	public List<Comment> getCommentList(QueryComment query) {
		logger.info("진입");
		return dao.getCommentList(query);
		
	}
	public int getTotalComment(int bbsSeq) {
		logger.info("진입");
		return dao.getTotalComment(bbsSeq);
		
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
