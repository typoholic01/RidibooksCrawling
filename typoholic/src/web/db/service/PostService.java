package web.db.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.PostDao;
import web.db.vo.Post;
import web.db.vo.QueryPost;

@Service
@Transactional
public class PostService {
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	private PostDao dao;
	
	@Autowired
	SqlSession session;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/

	public boolean insertPost(Post post) {
		logger.info("진입");
		dao = session.getMapper(PostDao.class);
		
		return dao.insertPost(post);
	} 


	/*************************************************
	 * 					READ
	 * ***********************************************/	

	public int getTotalPost(int postSeq) {
		logger.info("진입");
		dao = session.getMapper(PostDao.class);
		
		return dao.getTotalPost(postSeq);
	} 

	public Post getPost(int postSeq) {
		logger.info("진입");
		dao = session.getMapper(PostDao.class);
		
		return dao.getPost(postSeq);
	} 
	
	public List<Post> getPostList(QueryPost query) {
		logger.info("진입");
		dao = session.getMapper(PostDao.class);
		
		return dao.getPostList(query);
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	public boolean updatePost(Post post) {
		logger.info("진입");
		dao = session.getMapper(PostDao.class);
		
		return dao.updatePost(post);
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deletePost(int postSeq) {
		logger.info("진입");
		dao = session.getMapper(PostDao.class);
		
		return dao.deletePost(postSeq);
	}
}
