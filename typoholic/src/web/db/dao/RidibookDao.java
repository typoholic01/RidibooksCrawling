package web.db.dao;

import java.util.List;

import web.db.vo.Ridibook;
import web.view.util.Pagination;

public interface RidibookDao {
	
	//util
	int getTotalBook();
	
	/* SORTING */
	List<Ridibook> getRidibookListOrderByClapDESC(Pagination pagination);
	List<Ridibook> getRidibookListOrderByClapASC();
	
	void insertRidibook(Ridibook ridibook);
}