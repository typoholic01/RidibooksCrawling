package web.crawling.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.crawling.model.Ridibook;

public class CrawlingCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingCtrl.class);
	
	private CrawlingServ serv = new CrawlingServ();
	
	public List<Ridibook> crawling(String category, int page) throws IOException {
		logger.info("crawling");
		
		//변수 준비
		double star = -1;
		int starredPerson = 0;
		int rank = 1;
		//페이지 번호에 맞춰 랭크 Fixed
		rank = setRank(page);		

		//리턴값 준비
		List<Ridibook> bestSellerList = new ArrayList<>();				
		
		//크롤링 시작
		Document doc = serv.getFantasyDocument(category, page);
		
		List<String> linkList = serv.getTargetLink(doc);
		List<String> coverList = serv.getImgSrc(doc);
		List<String> authorList = serv.getAuthor(doc);
		List<String> titleList = serv.getTitle(doc);
		List<String> starList = serv.getRating(doc);
		List<String> starredPersonList = serv.getRatingPeople(doc);
		
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
			dto.setRank(rank);
			dto.setCover(coverList.get(i));
			dto.setTitle(titleList.get(i));
			dto.setAuthor(authorList.get(i));
			dto.setStar(star);
			dto.setStarredPerson(starredPerson);
			dto.setLink(linkList.get(i));
			
			rank++;
			bestSellerList.add(dto);
		}
		return bestSellerList;
	}

	private int setRank(int page) {
		int rank = 1;
		
		switch (page) {
		case 1:
			rank = 1;
			break;
		case 2:
			rank = 31;
			break;
		case 3:
			rank = 61;
			break;
		case 4:
			rank = 91;
			break;
		case 5:
			rank = 121;
			break;
		case 6:
			rank = 151;
			break;
		case 7:
			rank = 181;
			break;
		default:
			break;
		}
		return rank;
	}
}
