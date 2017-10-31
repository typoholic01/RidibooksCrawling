package web.db.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	//회원가입 화면
	@RequestMapping(value= "/user/account",method=RequestMethod.GET)
	public String account() {
		logger.info("진입");
		
		
		
		return "userAccount.tiles";
	}
	
	//회원가입 기능
	@RequestMapping(value= "/user/account",method=RequestMethod.POST)
	public String accountAf(User user) {
		logger.info("진입");
		
		logger.info(user.toString());
		
		serv.insertUser(user);
		
		
		return "userAccountSuccess.tiles";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//로그인 화면
	@RequestMapping(value= "/user/login",method=RequestMethod.GET)
	public String login() {
		logger.info("진입");
		
		
		
		return "userLogin.tiles";
	}
	//로그인 기능
	@RequestMapping(value= "/user/login",method=RequestMethod.POST)
	public String loginAf(User user, HttpServletRequest req) {
		logger.info("진입");		
		logger.info(user.toString());
		
		//init
		User login;
		HttpSession session;
		
		login = serv.getUser(user);
		session = req.getSession();
		session.setAttribute("login", login);
		
		return "userLoginSuccess.tiles";
	}
	//로그인 기능
	
	@RequestMapping(value= "/user/login",method=RequestMethod.PUT)
	public @ResponseBody String loginPUT(User user, HttpServletRequest req) {
		logger.info("진입");		
		logger.info(user.toString());
		
		//init
		User login;
		HttpSession session;
		
		login = serv.getUser(user);
		session = req.getSession();
		session.setAttribute("login", login);
		
		return "test";
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//로그인 기능
	@RequestMapping(value= "/user/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		logger.info("진입");
		
		//init
		HttpSession session;
		
		session = req.getSession();
		session.invalidate();
		
		return "userLogoutSuccess.tiles";
	}
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/

}