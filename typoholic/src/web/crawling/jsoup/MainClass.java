package web.crawling.jsoup;

import java.io.IOException;

public class MainClass {
	
	public static void main(String[] args) throws IOException {	
		Crawling ctrl = new Crawling();

		ctrl.getRidibookFantasyList(1);
		
	}

}
