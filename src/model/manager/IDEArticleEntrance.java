package model.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.dco.ArticleCompositeObject;
import model.entitys.Article;
import model.entitys.User;
import model.exception.NoMatchUserException;

public class IDEArticleEntrance implements Articable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Article> articles;

	public IDEArticleEntrance(List<Article> articles) {
		this.articles = articles;
	}

	public void initializeEntityManager(String persistenceUnitName) {
		
	}

	@Override
	public List<Article> fillRecords(EntityManager em) {
		TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
		List<Article> result = query.getResultList();
		
		String category = "IDE";
		String IDE;
		
		for(Article a : result) {
			IDE = a.getCategory().getArticlecategory();
			
			if(category.equals(IDE)) {
				articles.add(a);
			}
		}
		
		return articles;
	}
}
