package web.db.dao;

import java.util.List;

import web.db.vo.Comment;
import web.db.vo.QueryComment;

public interface CommentDao {
	
	/*					CREATE					*/
	boolean insertComment(Comment comment);
	
	/*					READ					*/
	Comment getComment(int commentSeq);
	List<Comment> getCommentList(QueryComment query);
	int getTotalComment(int bbsSeq);
	
	/*					UPDATE					*/
	boolean updateComment(Comment comment);

	/*					DELETE					*/
	boolean deleteComment(int commentSeq);

}
