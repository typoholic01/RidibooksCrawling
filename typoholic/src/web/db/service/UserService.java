package web.db.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.UserDao;
import web.db.vo.User;

@Service
@Transactional
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao dao;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	public boolean insertUser(User user) {
		logger.info("진입");
		
		return dao.insertUser(user);
	}
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public User getUser(User user) {
		logger.info("진입");
		return dao.getUser(user);
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deleteUser(User user) {
		logger.info("진입");
		
		return dao.deleteUser(user);
	}

}