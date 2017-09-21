package web.crawling.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import web.crawling.dao.RidibookDao;
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
		
		List<Ridibook> list = dao.getRidibookList();
		
		model.addAttribute("list", list);
		
		return "ridibooks/list";
	}
	
	@RequestMapping(value="/ridibooks/json/",method=RequestMethod.GET)
	public @ResponseBody List<Ridibook> ridibooksPut() {
		logger.info("ridibooksPut");
		
		RidibookDao dao = session.getMapper(RidibookDao.class);
		
		List<Ridibook> list = dao.getRidibookListOrderByStarredPersonDESC();
		
		return list;
	}
	
//	@RequestMapping(value="/ridibooks/crawling/",method=RequestMethod.GET)
//	public String crawling(Model model) throws IOException {
//		logger.info("crawling");
//		
//		RidibookDao dao = session.getMapper(RidibookDao.class);
//		Crawling ctrl = new Crawling();
//
//		for (int i = 1; i < 8; i++) {
//			List<Ridibook> list = ctrl.getRidibookFantasyList(i);
//			
//			for (Ridibook ridibook : list) {
//				dao.insertRidibook(ridibook);
//			}
//		}
//		
//		return "ridibooks/list";
//	}

}
