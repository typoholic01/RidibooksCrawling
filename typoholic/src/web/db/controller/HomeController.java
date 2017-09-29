package web.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * 0. 비 주기적으로 리디북스 DB정보를 갱신한다(사용자 실행)
	 * 		1. 리디북스 정보를 크롤링한다
	 * 		2. 크롤링한 정보를 JSON형태로 가공한다(필요하면)
	 * 		3. JSON정보를 DB에 넣는다
	 * 1. 주기적으로 리디북스 DB정보를 갱신한다
	 * 2. 갱신한 DB정보를 출력한다
	 * 3. 
	 * */

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(Model model) {
		logger.info("main");
		
		return "main.tiles";	
	}
	
	@RequestMapping(value="/write/", method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("write");
		
		return "write";		
	}
}
