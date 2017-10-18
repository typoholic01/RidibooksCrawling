package web.query.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("QueryBook")
public class QueryBook implements Serializable {
	private static final long serialVersionUID = -6316151656854713535L;
	
	private String category;					//책 분류
	private String queryType;					//정렬 기준
	private String direction;					//정렬 차순
	private int startListNum;					//Limit 시작 번호
	private int ListLimit;						//Limit 갯수
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getStartListNum() {
		return startListNum;
	}
	public void setStartListNum(int startListNum) {
		this.startListNum = startListNum;
	}
	public int getListLimit() {
		return ListLimit;
	}
	public void setListLimit(int listLimit) {
		ListLimit = listLimit;
	}
	@Override
	public String toString() {
		return "QueryBook [category=" + category + ", queryType=" + queryType + ", direction=" + direction
				+ ", startListNum=" + startListNum + ", ListLimit=" + ListLimit + "]";
	}
	
	
}
