package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.RidibooksDao;
import web.db.vo.Ridibook;
import web.view.util.Pagination;

@Service
@Transactional
public class RidibookSevice {
	private static final Logger logger = LoggerFactory.getLogger(RidibooksDao.class);
	
	@Autowired
	RidibooksDao dao;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	

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
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/

}
