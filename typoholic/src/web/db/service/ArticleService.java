package web.db.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import web.db.dao.ArticleDao;
import web.db.dao.CommentDao;
import web.db.dao.RidibookDao;
import web.db.vo.Article;
import web.db.vo.QueryArticle;
import web.db.vo.Ridibook;
import web.view.util.Pagination;

@Service
public class ArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	@Autowired
	ArticleDao dao;	

	/*************************************************
	 * 					CREATE
	 * ***********************************************/


	public boolean insertBbs(Article bbs) {
		logger.info("진입");
		return daoArticle.insertBbs(bbs);		
	}; 

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public int getTotalBbs(String boardName) {
		logger.info("진입");
		return daoArticle.getTotalBbs(boardName);
	} 
	public Article getBbs(int bbsSeq) {
		logger.info("진입");
		return daoArticle.getBbs(bbsSeq);
	} 
	public List<Article> getBbsList(QueryArticle query) {
		logger.info("진입");
		return daoArticle.getBbsList(query);		
	};
	

	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	public boolean updateBbs(Article bbs) {
		logger.info("진입");
		return daoArticle.updateBbs(bbs);
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/

	public boolean deleteBbs(int seq) {
		logger.info("진입");
		return daoArticle.deleteBbs(seq);
	}
}
