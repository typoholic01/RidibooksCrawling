package web.crawling.dao;

import java.util.List;

import web.crawling.util.Pagination;
import web.crawling.vo.Ridibook;

public interface RidibookDao {
	
	//util
	int getTotalBook();
	
	/* SORTING */
	List<Ridibook> getRidibookListOrderByClapDESC(Pagination pagination);
	List<Ridibook> getRidibookListOrderByClapASC();
	
	void insertRidibook(Ridibook ridibook);
}