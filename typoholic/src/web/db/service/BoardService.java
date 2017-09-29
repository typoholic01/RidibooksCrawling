package web.db.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import web.db.dao.ArticleDao;
import web.db.dao.CommentDao;
import web.db.dao.RidibookDao;
import web.db.vo.Ridibook;
import web.view.util.Pagination;

public class BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	SqlSession session;	
	
	ArticleDao daoArticle = session.getMapper(ArticleDao.class);
	CommentDao daoComment = session.getMapper(CommentDao.class);

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
}
