package web.crawling.jsoup;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlingServ {
	private CrawlingDao dao = new CrawlingDao();
	private Elements mainElements = null;
	
	public CrawlingServ() {
	
	}
	
	public Document getFantasyDocument(String category, int page) throws IOException {
		String url = "";
		
		//카테고리 선택
		switch (category) {
		case "판타지":
			url = "https://ridibooks.com/bestsellers/fantasy";
			break;

		default:
			break;
		}
		url = url+"?page="+page;
		
		Document doc = dao.getDocument(url);
		return doc;
	}
	
	private Elements getMainElements(Document doc) {
		if (mainElements == null) {
			mainElements = doc.select("#page_best > div.book_macro_wrapper.js_book_macro_wrapper > div:not(.recommended_book)");
		}
		return mainElements;
	}
	
	public List<String> getTargetLink(Document doc) throws IOException {
		Elements elements = getMainElements(doc);		
		
		return dao.hrefCrawling(elements, "div.book_thumbnail_wrapper > div > a");
		
	}
	
	public List<String> getImgSrc(Document doc) throws IOException {
		Elements elements = getMainElements(doc);		
		
		return dao.attrSrcCrawling(elements, "div.book_thumbnail_wrapper > div > div > img");
		
	}
	
	public List<String> getTitle(Document doc) throws IOException {
		Elements elements = getMainElements(doc);		
		
		return dao.textCrawling(elements, "div.book_metadata_wrapper > h3 > a > span");
		
	}
	
	public List<String> getAuthor(Document doc) throws IOException {
		Elements elements = getMainElements(doc);
		
		return dao.textCrawling(elements, "div.book_metadata_wrapper > p.book_metadata.author > a");
		
	}
	
	public List<String> getRating(Document doc) throws IOException {
		Elements elements = getMainElements(doc);
		
		return dao.textCrawling(elements, "div.book_metadata_wrapper > p.book_metadata.star_rate.hidden_for_landscape > span > span.score");
		
	}
	
	public List<String> getRatingPeople(Document doc) throws IOException {
		Elements elements = getMainElements(doc);
		
		return dao.textCrawling(elements, "div.book_metadata_wrapper > p.book_metadata.star_rate.hidden_for_landscape > span > span.count");
		
	}

}
