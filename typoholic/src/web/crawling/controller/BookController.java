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
import web.crawling.vo.Ridibook;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);	
		
	@Autowired
	SqlSession session;	
	
	@RequestMapping(value="/book/",method=RequestMethod.GET)
	public String book(Model model) {
		logger.info("book");
		RidibookDao dao = session.getMapper(RidibookDao.class);
		
		List<Ridibook> list = dao.getRidibookListOrderByClapDESC();
		
		model.addAttribute("list", list);
		
		return "booklist.tiles";
	}

}
