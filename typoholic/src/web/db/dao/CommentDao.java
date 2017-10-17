package web.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.db.vo.Comment;
import web.query.vo.QueryComment;

@Repository
public class CommentDao {
	private static final Logger logger = LoggerFactory.getLogger(CommentDao.class);
	private static final String ns = "Comments.";
	
	@Autowired
	SqlSession session;	
	
	/*******************************************
	 * 					CREATE					
	 * *****************************************/
	public boolean insertComment(Comment comment) {
		logger.info("진입");
		
		logger.info(comment.toString());
		
		return session.insert(ns+"insertComment", comment) > 0 ? true:false;
		
	}
	
	/*******************************************
	 * 					READ					
	 * *****************************************/
	public Comment getComment(int commentSeq) {
		logger.info("진입");
		
		return session.selectOne(ns+"getComment", commentSeq);
		
	}
	public List<Comment> getCommentList(QueryComment query) {
		logger.info("진입");
		
		return session.selectList(ns+"getCommentList", query);
		
	}
	public int getTotalComment(int bbsSeq) {
		logger.info("진입");
		
		return session.selectOne(ns+"getTotalComment", bbsSeq);
		
	}
	
	/*******************************************
	 * 					UPDATE					
	 * *****************************************/
	public boolean updateComment(Comment comment) {
		logger.info("진입");
		
		return session.update(ns+"updateComment", comment) > 0 ? true : false;
		
	}

	/*******************************************
	 * 					DELETE					
	 * *****************************************/
	public boolean deleteComment(int commentSeq) {
		logger.info("진입");
		
		return session.update(ns+"deleteComment", commentSeq) > 0 ? true : false;
		
	}

}
