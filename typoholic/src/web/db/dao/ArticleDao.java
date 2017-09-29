package web.db.dao;

import java.util.List;

import web.db.vo.Article;
import web.db.vo.QueryBoard;

public interface ArticleDao {

	public List<Article> getBbsList(QueryBoard query);

	public boolean insertBbs(Article bbs); 

	public int getTotalBbs(String boardName); 

	public Article getBbs(int bbsSeq); 

	public boolean deleteBbs(int seq);

	public boolean updateBbs(Article bbs);
}