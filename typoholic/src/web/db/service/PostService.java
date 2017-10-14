package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.PostDao;
import web.db.vo.Post;
import web.db.vo.User;
import web.query.vo.QueryPost;

@Service
@Transactional
public class PostService {
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostDao dao;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/

	public boolean insertPost(Post post) {
		logger.info("진입");
		
		return dao.insertPost(post);
	} 


	/*************************************************
	 * 					READ
	 * ***********************************************/	

	public int getTotalPost(String boardUrl) {
		logger.info("진입");
		
		return dao.getTotalPost(boardUrl);
	} 

	public Post getPost(int postSeq) {
		logger.info("진입");
		
		return dao.getPost(postSeq);
	} 
	
	public List<Post> getPostList(QueryPost query) {
		logger.info("진입");
		
		return dao.getPostList(query);
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	public boolean updatePost(Post post) {
		logger.info("진입");
		
		return dao.updatePost(post);
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deletePost(int postSeq) {
		logger.info("진입");		
		
		return dao.deletePost(postSeq);
	}


	public String getPostUserId(int postSeq) {
		logger.info("진입");		
		
		return dao.getPostUserId(postSeq);
	}
}
