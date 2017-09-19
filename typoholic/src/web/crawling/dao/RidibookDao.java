package web.crawling.dao;

import java.util.List;

import web.crawling.vo.Ridibook;

public interface RidibookDao {

	List<Ridibook> getRidibookList();
	void insertRidibook(Ridibook ridibook);
}