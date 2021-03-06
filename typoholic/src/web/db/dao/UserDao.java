package web.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.db.vo.User;

@Repository
public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	private static final String ns = "Users.";
	
	@Autowired
	SqlSession session;	

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	public boolean insertUser(User user) {
		logger.info("진입");
		
		return session.insert(ns+"insertUser", user) > 0 ? true:false;
	}
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public User getUser(User user) {
		logger.info("진입");
		return session.selectOne(ns+"getUser", user);
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deleteUser(User user) {
		logger.info("진입");
		
		//init
		int n = 0;
		
		try {
			n = session.delete(ns+"deleteUser", user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		return n > 0 ? true:false;
	}

}
