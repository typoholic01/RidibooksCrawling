package web.db.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import web.db.dao.RidibookDao;
import web.db.vo.Ridibook;
import web.view.util.Pagination;

public class BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	SqlSession session;	
	
	RidibookDao dao = session.getMapper(RidibookDao.class);

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public int getTotalBook() {
		return dao.getTotalBook();
	}
	
	/* SORTING */
	public List<Ridibook> getRidibookListOrderByClapDESC(Pagination pagination) {
		return dao.getRidibookListOrderByClapDESC(pagination);
	}
	public List<Ridibook> getRidibookListOrderByClapASC() {
		return dao.getRidibookListOrderByClapASC();
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
}
