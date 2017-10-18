package web.crawling.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.db.vo.Ridibook;

public class BestFantasy {
	private static final Logger logger = LoggerFactory.getLogger(BestFantasy.class);
	
	public List<Ridibook> getRidibookList(String category, String url) throws IOException {
		logger.info("진입");
		//init
		List<Ridibook> bookList = new ArrayList<>();
		List<String> linkList;
		List<String> coverList;
		List<String> titleList;
		List<String> authorList;
		List<String> starList;
		List<String> starredPersonList;
		
		//변수 준비
		double star = -1;
		int starredPerson = 0;
		
		//페이지 번호에 맞춰 랭크 Fixed
				
		//crawling
		CrawlingUtil util = new CrawlingUtil(url, 
				"#page_best > div.book_macro_wrapper.js_book_macro_wrapper > "
				+ "div:not(.recommended_book)");
		
		linkList = util.attrHrefCrawling("div.book_thumbnail_wrapper > div > a");
		
		coverList = util.attrSrcCrawling("div.book_thumbnail_wrapper > div > div > img");

		titleList = util.textCrawling("div.book_metadata_wrapper > h3 > a > span");
		
		authorList = util.textCrawling("div.book_metadata_wrapper > p.book_metadata.author > a");
		
		starList = util.textCrawling("div.book_metadata_wrapper > p.book_metadata.star_rate.hidden_for_landscape > span > span.score");
	
		starredPersonList = util.textCrawling("div.book_metadata_wrapper > p.book_metadata.star_rate.hidden_for_landscape > span > span.count");
	
		//beans에 삽입
		for (int i = 0; i < linkList.size(); i++) {
			//초기화
			star = -1;
			starredPerson = 0;

			//값 넣기
			if (starList.get(i) != null && !starList.get(i).equals("")) {
				star = Double.parseDouble(starList.get(i).substring(0, 3));
			}
			if (starredPersonList.get(i) != null && !starredPersonList.get(i).equals("")) {
				starredPerson = Integer.parseInt(starredPersonList.get(i).replaceAll("\\D", ""));
			}
			
			Ridibook dto = new Ridibook();
			dto.setCategory(category);
			dto.setCover(coverList.get(i));
			dto.setTitle(titleList.get(i));
			dto.setAuthor(authorList.get(i));
			dto.setStar(star);
			dto.setStarredPerson(starredPerson);
			dto.setLink(linkList.get(i));
			
			bookList.add(dto);
		}
		return bookList;
	}
	
}