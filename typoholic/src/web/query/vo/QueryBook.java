package web.query.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("QueryBook")
public class QueryBook implements Serializable {
	private static final long serialVersionUID = -6316151656854713535L;
	
	private String category;					//책 분류
	private String directionType;				//정렬 기준
	private String direction;					//정렬 차순
	private String queryType;					//질의 기준
	private String query;						//질의 
	private int startListNum;					//Limit 시작 번호
	private int ListLimit;						//Limit 갯수
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirectionType() {
		return directionType;
	}
	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
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
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	@Override
	public String toString() {
		return "QueryBook [category=" + category + ", directionType=" + directionType + ", direction=" + direction
				+ ", queryType=" + queryType + ", query=" + query + ", startListNum=" + startListNum + ", ListLimit="
				+ ListLimit + "]";
	}
	
	
	
	
	
	
}
