package web.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostFileDao {
	private static final Logger logger = LoggerFactory.getLogger(PostFileDao.class);
	private static final String ns = "PostFiles.";
	
	@Autowired
	SqlSession session;	
	

	/*******************************************
	 * 					CREATE					
	 * *****************************************/
	public boolean insertPostFile() {
		logger.info("진입");
		
		return session.insert(ns+"insertPostFile") > 0 ? true:false;
		
	}
	
	/*******************************************
	 * 					READ					
	 * *****************************************/
	
	
	/*******************************************
	 * 					UPDATE					
	 * *****************************************/
	

	/*******************************************
	 * 					DELETE					
	 * *****************************************/
	
}