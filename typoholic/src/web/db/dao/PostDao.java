package web.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.db.vo.Post;
import web.query.vo.QueryPost;

@Repository
public class PostDao {
	private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
	private static final String ns = "Posts.";
	
	@Autowired
	SqlSession session;	
	

	/*******************************************
	 * 					CREATE					
	 * *****************************************/
	public boolean insertPost(Post post) {
		logger.info("진입");
		
		return session.insert(ns+"insertPost", post) > 0 ? true:false;
		
	}
	
	/*******************************************
	 * 					READ					
	 * *****************************************/
	
	public Post getPost(int postSeq) {
		logger.info("진입");
		
		return session.selectOne(ns+"getPost", postSeq);
		
	}
	
	public List<Post> getPostList(QueryPost query) {
		logger.info("진입");
		
		return session.selectList(ns+"getPostList", query);
		
	}
	
	public int getTotalPost(String boardUrl) {
		logger.info("진입");
		
		return session.selectOne(ns+"getTotalPost", boardUrl);
		
	}
	
	public String getPostUserId(int postSeq) {
		logger.info("진입");
		
		return session.selectOne(ns+"getPostUserId", postSeq);
	}
	
	/*******************************************
	 * 					UPDATE					
	 * *****************************************/
	public boolean updatePost(Post post) {
		logger.info("진입");
		
		return session.update(ns+"updatePost", post) > 0 ? true : false;
		
	}

	/*******************************************
	 * 					DELETE					
	 * *****************************************/
	public boolean deletePost(int postSeq) {
		logger.info("진입");
		
		return session.update(ns+"deletePost", postSeq) > 0 ? true : false;
		
	}
}