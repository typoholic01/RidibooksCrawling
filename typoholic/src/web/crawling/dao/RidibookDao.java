package web.crawling.dao;

import java.util.List;

import web.crawling.model.Ridibook;

public interface RidibookDao {

	List<Ridibook> getRidibookList() throws Exception;
}
