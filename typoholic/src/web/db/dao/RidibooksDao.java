package web.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.db.vo.Ridibook;
import web.query.vo.QueryBook;
import web.view.util.Pagination;

@Repository
public class RidibooksDao {
	private static final Logger logger = LoggerFactory.getLogger(RidibooksDao.class);
	private static final String ns = "Ridibook.";
	
	@Autowired
	SqlSession session;	

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	public boolean insertRidibook(Ridibook ridibook) {
		logger.info("진입");
		
		return session.insert(ns+"insertRidibook", ridibook) > 0 ? true:false;
	}
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public int getTotalBook() {
		logger.info("진입");
		return session.selectOne(ns+"getTotalBook");
	}
	
	/* SORTING */
	public List<Ridibook> getRidibookListOrderByClapDESC(Pagination pagination) {
		logger.info("진입");
		return session.selectList(ns+"getRidibookListOrderByClapDESC",pagination);
	}
	public List<Ridibook> getRidibookListOrderByClapASC() {
		logger.info("진입");
		return session.selectList(ns+"getRidibookListOrderByClapASC");
	}


	public List<Ridibook> getRidibookList(QueryBook query) {
		logger.info("진입");
		return session.selectList(ns+"getRidibookList",query);
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
}
