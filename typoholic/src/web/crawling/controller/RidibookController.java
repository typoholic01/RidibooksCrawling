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

import web.crawling.dao.RidibookDao;
import web.crawling.model.Ridibook;

@Controller
public class RidibookController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Autowired
	SqlSession session;
	
	@RequestMapping(value="/ridibooks/",method=RequestMethod.GET)
	public String ridibooks(Model model) throws Exception {
		logger.info("ridibooks");
		
		RidibookDao dao = session.getMapper(RidibookDao.class);
		
		List<Ridibook> list = dao.getRidibookList();
		
		model.addAttribute("list", list);
		
		return "ridibooks/list";
	}

}
