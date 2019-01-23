package model.manager;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import model.entitys.Article;

public class ArticleManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Articable article;
	
	public ArticleManager() {
		
	}
	
	public ArticleManager(Articable article) {
		this.article = article;
	}
	
	public void setArticleEntrance(Articable article) {
		this.article = article;
	}
	
	public List<Article> fillRecords(EntityManager em) {
		return article.fillRecords(em);
	}

}
