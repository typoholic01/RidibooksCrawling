package web.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.db.service.UserService;
import web.db.vo.User;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	//http://springboot.tistory.com/25 예외처리
	
	@Autowired
	UserService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/user/account",method=RequestMethod.GET)
	public String write() {
		logger.info("진입");
		
		
		
		return "userAccount.tiles";
	}
	//글쓰기 기능
	@RequestMapping(value= "/user/account",method=RequestMethod.POST)
	public String writeAf(User user) {
		logger.info("진입");
		
		logger.info(user.toString());
		
		serv.insertUser(user);
		
		
		return "userAccountSuccess.tiles";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/

}