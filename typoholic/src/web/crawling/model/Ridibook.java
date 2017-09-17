package web.crawling.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Ridibook implements Serializable {
	private static final long serialVersionUID = -4572117714450559088L;
	
	private String category;
	private int rank;
	private String cover;
	private String title;
	private String author;
	private double star;
	private int starredPerson;
	private String link;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}		
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	public int getStarredPerson() {
		return starredPerson;
	}
	public void setStarredPerson(int starredPerson) {
		this.starredPerson = starredPerson;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Ridibook [category=" + category + ", rank=" + rank + ", cover=" + cover + ", title=" + title
				+ ", author=" + author + ", star=" + star + ", starredPerson=" + starredPerson + ", link=" + link + "]";
	}

}
