package web.db.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.crawling.jsoup.BestFantasy;
import web.db.service.RidibookService;
import web.db.vo.Ridibook;

@Controller
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Autowired
	RidibookService serv;
	
	@RequestMapping(value="/crawling/ridibooks/{category}/{page}",method=RequestMethod.GET)
	public String crawling(@PathVariable String category,@PathVariable String page, HttpServletRequest req) throws IOException {
		logger.info("crawling");
		BestFantasy ctrl = new BestFantasy();
		String url;
		String prefix;
		String parameter;
		
		//url 세팅
		prefix = "https://ridibooks.com/bestsellers/";
		parameter = "?page="+page;
		url = prefix + category + parameter;
		
		logger.info(url);

		List<Ridibook> list = ctrl.getRidibookList(category, url);
		
		for (Ridibook ridibook : list) {
			try {
				serv.insertRidibook(ridibook);					
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		return "redirect:/book";
	}

	private String getParameter(HttpServletRequest req, String parameter) {
		if (req.getParameter(parameter) == null) {
			return "";
		} else {
			return req.getParameter(parameter);
		}
	}

}
