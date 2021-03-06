package web.query.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("QueryComment")
public class QueryComment implements Serializable {
	private static final long serialVersionUID = -2619339902153486228L;
	
	private String boardUrl;					//게시판 제목
	private int postSeq;						//게시물 번호
	private int commentSeq;						//코멘트 번호
	private int startArticle;					//시작 코멘트
	private int endArticle;						//끝 코멘트
	private int articleLimit;					//게시물 제한
	
	public String getBoardUrl() {
		return boardUrl;
	}
	public void setBoardUrl(String boardUrl) {
		this.boardUrl = boardUrl;
	}
	public int getPostSeq() {
		return postSeq;
	}
	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public int getStartArticle() {
		return startArticle;
	}
	public void setStartArticle(int startArticle) {
		this.startArticle = startArticle;
	}
	public int getEndArticle() {
		return endArticle;
	}
	public void setEndArticle(int endArticle) {
		this.endArticle = endArticle;
	}
	public int getArticleLimit() {
		return articleLimit;
	}
	public void setArticleLimit(int articleLimit) {
		this.articleLimit = articleLimit;
	}
	@Override
	public String toString() {
		return "QueryComment [boardUrl=" + boardUrl + ", postSeq=" + postSeq + ", commentSeq=" + commentSeq
				+ ", startArticle=" + startArticle + ", endArticle=" + endArticle + ", articleLimit=" + articleLimit
				+ "]";
	}
	
	
	
	
	
}
