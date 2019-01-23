package model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entitys.Article;

public class IDEArticleEntrance implements Articable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IDEArticleEntrance() {

	}

	@Override
	public List<Article> fillRecords(EntityManager em) {
		TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
		List<Article> result = query.getResultList();

		List<Article> articles = new ArrayList<Article>();
		String category = "IDE";
		String IDE;

		for (Article a : result) {
			IDE = a.getCategory().getArticlecategory();

			if (category.equals(IDE)) {
				articles.add(a);
			}
		}

		if (em.isOpen())
			em.close();

		return articles;

	}
}
