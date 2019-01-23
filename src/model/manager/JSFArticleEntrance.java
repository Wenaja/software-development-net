package model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entitys.Article;

public class JSFArticleEntrance implements Articable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JSFArticleEntrance() {
		
	}

	@Override
	public List<Article> fillRecords(EntityManager em) {
		TypedQuery<Article> query = em.createQuery("", Article.class);
		List<Article> results = query.getResultList();
		
		List<Article> articles = new ArrayList<Article>();
		String category = "JSF";
		String JSF;
		
		for(Article a : results) {
			JSF = a.getCategory().getArticlecategory();
			
			if(category.equals(JSF)) {
				articles.add(a);
			}
		}
		
		return articles;
		
	}

}
