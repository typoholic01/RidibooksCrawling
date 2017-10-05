package web.db.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("QueryPost")
public class QueryPost implements Serializable {
	private static final long serialVersionUID = -2619339902153486228L;
	
	private int boardSeq;						//게시판 제목
	private int postSeq;						//질의 번호
	private int startArticle;					//시작 게시물
	private int endArticle;						//끝 게시물
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getPostSeq() {
		return postSeq;
	}
	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
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
	
	@Override
	public String toString() {
		return "QueryPost [boardSeq=" + boardSeq + ", postSeq=" + postSeq + ", startArticle=" + startArticle
				+ ", endArticle=" + endArticle + "]";
	}

	
	
}
