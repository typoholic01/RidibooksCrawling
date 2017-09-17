package web.crawling.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrawlingDao {
    private static final Logger logger = LoggerFactory.getLogger(CrawlingDao.class);
	
    //html문서를 받아온다
	public Document getDocument(String url) throws IOException {
		
		Document document = Jsoup.connect(url)
				.header("Accept", 
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Encoding", "gzip, deflate, sdch, br")
				.header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
				.header("User-Agent", 
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
				.header("Connection","Keep-Alive")
				.header("Host","ridibooks.com")
				.get();

		logger.info("setDocument");
		return document;
	}

	//Doc문서로 메인 Elements를 추출한다
	public Elements getMainElements(Document document, String CSSSelect) {		
		Elements extractElements = document.select(CSSSelect);
		logger.info("setElements");
		
		return extractElements;
	}
	
	//받아온 문서를 이용해 a href데이터를 추출한다
	public List<String> hrefCrawling(Elements elements, String CSSSelect) throws IOException {
		List<String> list = new ArrayList<>();

		for (Element ahrefEl : elements) {
			Elements ahref = ahrefEl.select(CSSSelect);
			list.add(ahref.attr("href"));
		}
		return list;
	}
	
	//받아온 문서를 이용해 img데이터를 추출한다
	public List<String> attrSrcCrawling(Elements elements, String CSSSelect) throws IOException {
		List<String> list = new ArrayList<>();
		
		for (Element attrSrcEl : elements) {
			Elements attrSrc = attrSrcEl.select(CSSSelect);
			list.add(attrSrc.attr("src"));
		}
		return list;
	}
	
	public List<String> textCrawling(Elements elements, String CSSSelect) throws IOException {
		List<String> list = new ArrayList<>();
		
		for (Element element : elements) {
			Elements text = element.select(CSSSelect);
			list.add(text.text());
		}
		return list;
	}
}
