package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.FileDao;
import web.db.dao.PostDao;
import web.db.dao.PostFileDao;
import web.db.vo.File;
import web.db.vo.Post;
import web.query.vo.QueryPost;

@Service
@Transactional
public class PostService {
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	FileDao fileDao;
	
	@Autowired
	PostFileDao postFileDao;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/

	public boolean insertPost(Post post, File file) {
		logger.info("진입");
		boolean b;
		
		b = postDao.insertPost(post);
		//파일이 있을 경우에만 저장
		if (file != null && file.getOriginalFileName().equals("-1") == false) {
			fileDao.insertFile(file);
			postFileDao.insertPostFile();			
		}
		
		return b;
	} 


	/*************************************************
	 * 					READ
	 * ***********************************************/	

	public int getTotalPost(String boardUrl) {
		logger.info("진입");
		
		return postDao.getTotalPost(boardUrl);
	} 

	public Post getPost(int postSeq) {
		logger.info("진입");
		
		return postDao.getPost(postSeq);
	} 
	
	public List<Post> getPostList(QueryPost query) {
		logger.info("진입");
		
		return postDao.getPostList(query);
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	public boolean updatePost(Post post) {
		logger.info("진입");
		
		return postDao.updatePost(post);
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deletePost(int postSeq) {
		logger.info("진입");		
		
		return postDao.deletePost(postSeq);
	}


	public String getPostUserId(int postSeq) {
		logger.info("진입");		
		
		return postDao.getPostUserId(postSeq);
	}
}
