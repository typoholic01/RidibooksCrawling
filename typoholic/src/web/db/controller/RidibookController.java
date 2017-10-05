//package web.db.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import web.crawling.jsoup.BestFantasy;
//import web.db.service.RIdibookSevice;
//import web.db.vo.Ridibook;
//
//@Controller
//public class RidibookController {
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
//	
//	@Autowired
//	RIdibookSevice serv;
//	
//	@RequestMapping(value="/ridibooks/crawling/",method=RequestMethod.GET)
//	public String crawling(Model model) throws IOException {
//		logger.info("crawling");
//		BestFantasy ctrl = new BestFantasy();
//
//		for (int i = 1; i < 8; i++) {
//			List<Ridibook> list = ctrl.getRidibookFantasyList(i);
//			
//			for (Ridibook ridibook : list) {
//				try {
//					serv.insertRidibook(ridibook);					
//				} catch (Exception e) {
//					logger.error(e.getMessage());
//				}
//			}
//		}
//		
//		return "ridibooks/list";
//	}
//
//}
