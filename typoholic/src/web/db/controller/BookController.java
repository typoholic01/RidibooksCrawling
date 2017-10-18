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

import web.db.service.RidibookService;
import web.db.vo.Ridibook;
import web.query.vo.QueryBook;
import web.view.util.Pagination;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);	
		
	@Autowired
	RidibookService serv;
	
	@RequestMapping(value="/book",method=RequestMethod.GET)
	public String book(QueryBook query, Model model, HttpServletRequest req) {
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

		//Query Set
		query.setStartListNum(pagination.getStartArticle());
		query.setListLimit(pagination.getArticleLimit());
		
		if (query.getQueryType() == null) {
			query.setQueryType("clap");
			query.setDirection("DESC");
		}

		logger.info("query: {}", query.toString());
		
		//DB get
		list = serv.getRidibookList(query);
		
		//속성 넣기
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "booklist.tiles";
	}

	@RequestMapping(value="/book/json",method=RequestMethod.GET)
	public @ResponseBody List<Ridibook> ridibooksPut(QueryBook query, HttpServletRequest req) {
		logger.info("진입");
		//init
		Pagination pagination;
		List<Ridibook> list = null;
		int page;
		int totalBook;
		
		//listen
		page = getPage(req);
		
		//DB get
		totalBook = serv.getTotalBook();
		
		//paging
		pagination = new Pagination(totalBook, page);
		
		//Query Set
		query.setStartListNum(pagination.getStartArticle());
		query.setListLimit(pagination.getArticleLimit());
		
		logger.info("query: {}", query.toString());
		
		//run
		list = serv.getRidibookList(query);
		
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
