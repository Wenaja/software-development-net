package model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entitys.Article;

public class JPAArticleEntrance implements Articable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPAArticleEntrance() {

	}

	@Override
	public List<Article> fillRecords(EntityManager em) {
		TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
		List<Article> results = query.getResultList();

		List<Article> articles = new ArrayList<Article>();
		String category = "JPA";
		String JPA;

		for (Article a : results) {
			JPA = a.getCategory().getArticlecategory();

			if (category.equals(JPA)) {
				articles.add(a);
			}
		}

		if (em.isOpen())
			em.close();

		return articles;

	}

}
