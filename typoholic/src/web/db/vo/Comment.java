package web.db.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 7102612417387175157L;
	
	private int postSeq;
	private int groupNo;
	private String depth;
	private int commentSeq;
	private String status;
	private String userId;
	private String content;
	private String createAt;
	private String updatedAt;
	
	public int getPostSeq() {
		return postSeq;
	}
	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
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
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "Comment [postSeq=" + postSeq + ", groupNo=" + groupNo + ", depth=" + depth + ", commentSeq="
				+ commentSeq + ", status=" + status + ", userId=" + userId + ", content=" + content + ", createAt="
				+ createAt + ", updatedAt=" + updatedAt + "]";
	}

}