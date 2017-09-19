package web.crawling.dao;

import java.util.List;

import web.crawling.vo.Ridibook;

public interface RidibookDao {

	List<Ridibook> getRidibookList();
	
	/* SORTING */
	List<Ridibook> getRidibookListOrderByStarredPersonASC();
	List<Ridibook> getRidibookListOrderByStarredPersonDESC();
	
	void insertRidibook(Ridibook ridibook);
}