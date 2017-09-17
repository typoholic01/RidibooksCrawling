package web.crawling.jsoup;

import java.io.IOException;

public class MainClass {
	
	public static void main(String[] args) throws IOException {		
		String category = "판타지";
		
		CrawlingCtrl ctrl = new CrawlingCtrl();
		
		for (int i = 1; i <= 7; i++) {
			ctrl.crawling(category, i);
		}	
	}

}
