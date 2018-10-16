package model.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.dco.ArticleCompositeObject;

public class ArticleEntrance {
	private EntityManager em = null;

	public ArticleEntrance() {

	}

	public void initializeEntityManager(String persistenceUnitName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.em = emf.createEntityManager();

	}

	@SuppressWarnings("unchecked")
	public void fillRecords(List<ArticleCompositeObject> records) {
		String s = "IDE";
		Query query = em
				.createQuery("SELECT a.category.articlecategory, a.title.caption, a.article FROM Article a");
		List<Object[]> queryList = query.getResultList();

		for (Object[] o : queryList) {
			if (s.equals((String) o[0])) {
				records.add(new ArticleCompositeObject((String) o[0], (String) o[1], (String) o[2]));
			} /*
				 * else { records.add(new ArticleCompositeObject((String)o[0], (String)o[1],
				 * "<h3>" + (String)o[1] + "</h3>")); records.add(new
				 * ArticleCompositeObject((String)o[0], (String)o[1], (String)o[2])); s =
				 * (String)o[1]; }
				 */

		}

	}
}
