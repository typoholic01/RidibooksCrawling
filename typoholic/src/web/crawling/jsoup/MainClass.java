package web.crawling.jsoup;

public class MainClass {

	public static void main(String[] args) {		
		int page = 1;
		String url = "https://ridibooks.com/keyword-finder/fantasy?sub_genre=fantasy&group_id=18&tag_ids[]=89";

//		CrawlingUtil util = new CrawlingUtil(url, 
//				"#keywordFinder > div.finder_result > section");
		CrawlingUtil util = new CrawlingUtil(url, 
				"body");
		
		System.out.println(util.toString());
	}

}
