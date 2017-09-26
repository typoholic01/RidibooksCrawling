package web.crawling.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import web.crawling.util.Pagination;
import web.crawling.vo.Ridibook;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);	
		
	@Autowired
	SqlSession session;	
	
	@RequestMapping(value="/book/",method=RequestMethod.GET)
	public String book(Model model, HttpServletRequest req) {
		logger.info("book");
		RidibookDao dao = session.getMapper(RidibookDao.class);
		String pageStr;
		int page;
		
		
		//페이징 처리
		pageStr = req.getParameter("page");
		
		if (pageStr == null) page = 1;
		else page = Integer.parseInt(pageStr);
		
		int totalBook = dao.getTotalBook();
		
		Pagination pagination = new Pagination(totalBook, page);
		logger.info(pagination.toString());
		
		
		//리스트 받아오기
		List<Ridibook> list = dao.getRidibookListOrderByClapDESC(pagination);
		
		
		//속성 넣기
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "booklist.tiles";
	}
	
	@RequestMapping(value="/book/json/",method=RequestMethod.GET)
	public @ResponseBody List<Ridibook> ridibooksPut(HttpServletRequest req) {
		logger.info("ridibooksPut");
		String queryType = req.getParameter("queryType");
		String direction = req.getParameter("direction");
		String pageStr = req.getParameter("page");
		int page;
		
		logger.info("queryType: {} \t\t direction: {}",queryType,direction);
		RidibookDao dao = session.getMapper(RidibookDao.class);
		
		//init
		List<Ridibook> list = null;
		
		dao = session.getMapper(RidibookDao.class);
		
		
		//페이징 처리
		pageStr = req.getParameter("page");
		
		if (pageStr == null) page = 1;
		else page = Integer.parseInt(pageStr);
		
		int totalBook = dao.getTotalBook();
		
		Pagination pagination = new Pagination(totalBook, page);
		
		
		//정렬
		if (direction.equals("desc")) {
			if (queryType.equals("star"))
				list = null;
			else if (queryType.equals("clap"))
				list = dao.getRidibookListOrderByClapDESC(pagination);
		} else {
			if (queryType.equals("star"))
				list = null;
			else if (queryType.equals("clap"))
				list = dao.getRidibookListOrderByClapASC();	
		}		
		
		return list;
	}

}
