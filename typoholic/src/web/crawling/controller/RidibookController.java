package web.crawling.controller;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.crawling.dao.RidibookDao;
import web.crawling.jsoup.Crawling;
import web.crawling.vo.Ridibook;

@Controller
public class RidibookController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
		
	@Autowired
	SqlSession session;	
	
	@RequestMapping(value="/ridibooks/",method=RequestMethod.GET)
	public String ridibooks(Model model) {
		logger.info("ridibooks");
		RidibookDao dao = session.getMapper(RidibookDao.class);
		
		List<Ridibook> list = dao.getRidibookListOrderByClapDESC();
		
		model.addAttribute("list", list);
		
		return "ridibooks/list";
	}
	
	@RequestMapping(value="/ridibooks/json/",method=RequestMethod.GET)
	public @ResponseBody List<Ridibook> ridibooksPut(@RequestParam("queryType") String queryType, @RequestParam("direction") String direction) {
		logger.info("ridibooksPut");
		logger.info("queryType: {} \t\t direction: {}",queryType,direction);
		RidibookDao dao = session.getMapper(RidibookDao.class);
		
		//init
		List<Ridibook> list = null;
		
		dao = session.getMapper(RidibookDao.class);
		
		if (direction.equals("desc")) {
			if (queryType.equals("star"))
				list = null;
			else if (queryType.equals("clap"))
				list = dao.getRidibookListOrderByClapDESC();
		} else {
			if (queryType.equals("star"))
				list = null;
			else if (queryType.equals("clap"))
				list = dao.getRidibookListOrderByClapASC();	
		}		
		
		return list;
	}
	
	@RequestMapping(value="/ridibooks/crawling/",method=RequestMethod.POST)
	public String crawling(Model model) throws IOException {
		logger.info("crawling");
		RidibookDao dao = session.getMapper(RidibookDao.class);
		Crawling ctrl = new Crawling();

		for (int i = 1; i < 8; i++) {
			List<Ridibook> list = ctrl.getRidibookFantasyList(i);
			
			for (Ridibook ridibook : list) {
				try {
					dao.insertRidibook(ridibook);					
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		
		return "ridibooks/list";
	}

}
