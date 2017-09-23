package web.crawling.dao;

import java.util.List;

import web.crawling.vo.Ridibook;

public interface RidibookDao {
	
	/* SORTING */
	List<Ridibook> getRidibookListOrderByClapDESC();
	List<Ridibook> getRidibookListOrderByClapASC();
	
	void insertRidibook(Ridibook ridibook);
}