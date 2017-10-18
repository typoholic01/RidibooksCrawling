package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.RidibooksDao;
import web.db.vo.Ridibook;
import web.query.vo.QueryBook;
import web.view.util.Pagination;

@Service
@Transactional
public class RidibookService {
	private static final Logger logger = LoggerFactory.getLogger(RidibooksDao.class);
	
	@Autowired
	RidibooksDao dao;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/

	public boolean insertRidibook(Ridibook ridibook) {
		logger.info("진입");
		
		return dao.insertRidibook(ridibook);
		
	}
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public int getTotalBook() {
		logger.info("진입");
		return dao.getTotalBook();
	}
	
	/* SORTING */
	public List<Ridibook> getRidibookListOrderByClapDESC(Pagination pagination) {
		logger.info("진입");
		return dao.getRidibookListOrderByClapDESC(pagination);
	}
	public List<Ridibook> getRidibookListOrderByClapASC() {
		logger.info("진입");
		return dao.getRidibookListOrderByClapASC();
	}


	public List<Ridibook> getRidibookList(QueryBook query) {
		logger.info("진입");
		return dao.getRidibookList(query);
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/

}