package web.db.dao;

import java.util.List;

import web.db.vo.Post;
import web.db.vo.QueryPost;

public interface PostDao {
	

	/*******************************************
	 * 					CREATE					
	 * *****************************************/
	boolean insertPost(Post post);
	
	/*******************************************
	 * 					READ					
	 * *****************************************/
	Post getPost(int postSeq);
	List<Post> getPostList(QueryPost query);
	int getTotalPost(int postSeq);
	
	/*******************************************
	 * 					UPDATE					
	 * *****************************************/
	boolean updatePost(Post post);

	/*******************************************
	 * 					DELETE					
	 * *****************************************/
	boolean deletePost(int postSeq);
}