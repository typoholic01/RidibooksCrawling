package web.db.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1843374038002416069L;
	
	private int boardSeq;
	private int groupNo;
	private String depth;
	private int seq;
	private String status;
	private String userId;
	private String title;
	private String content;
	private int readCount;
	private String createAt;
	private String updateAt;
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
	public String toString() {
		return "Post [boardSeq=" + boardSeq + ", groupNo=" + groupNo + ", depth=" + depth + ", seq=" + seq + ", status="
				+ status + ", userId=" + userId + ", title=" + title + ", content=" + content + ", readCount="
				+ readCount + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
}
