package web.db.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import web.db.service.BookService;
import web.db.vo.Ridibook;
import web.view.util.Pagination;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);	
		
	@Autowired
	BookService serv;
	
	@RequestMapping(value="/book/",method=RequestMethod.GET)
	public String book(Model model, HttpServletRequest req) {
		logger.info("book");
		//init
		int page;		
		int totalBook;
		Pagination pagination;
		List<Ridibook> list;
		
		//listen
		page = getPage(req);
		
		//DB get
		totalBook = serv.getTotalBook();
		
		//paging
		pagination = new Pagination(totalBook, page);
		
		//DB get
		list = serv.getRidibookListOrderByClapDESC(pagination);		
		
		//속성 넣기
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "booklist.tiles";
	}

	@RequestMapping(value="/book/json/",method=RequestMethod.GET)
	public @ResponseBody List<Ridibook> ridibooksPut(HttpServletRequest req) {
		logger.info("ridibooksPut");
		//init
		Pagination pagination;
		List<Ridibook> list = null;
		String queryType;
		String direction;
		int page;
		int totalBook;
		
		//listen
		queryType = req.getParameter("queryType");
		direction = req.getParameter("direction");
		page = getPage(req);

		logger.info("queryType: {} \t\t direction: {}",queryType,direction);
		
		//DB get
		totalBook = serv.getTotalBook();
		
		//paging
		pagination = new Pagination(totalBook, page);
		
		
		//정렬(객체화)
		if (direction.equals("desc")) {
			if (queryType.equals("star"))
				list = null;
			else if (queryType.equals("clap"))
				list = serv.getRidibookListOrderByClapDESC(pagination);
		} else {
			if (queryType.equals("star"))
				list = null;
			else if (queryType.equals("clap"))
				list = serv.getRidibookListOrderByClapASC();	
		}
		
		return list;
	}

	/************************************************************
	 * 							Util Method 
	 * **********************************************************/

	
	private int getPage(HttpServletRequest req) {
		int page;
		
		if (req.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(req.getParameter("page"));
		}
		
		return page;
	}
}
