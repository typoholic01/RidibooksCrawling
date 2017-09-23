package web.crawling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/board/write/", method=RequestMethod.GET)
	public String write(Model model) throws Exception {
		logger.info("board/write");
		
		return "board/write";		
	}
	
	@RequestMapping(value="/board/detail/", method=RequestMethod.GET)
	public String detail(Model model) throws Exception {
		logger.info("board/detail");
		
		return "board/detail";		
	}
}
