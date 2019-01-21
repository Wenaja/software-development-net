package model.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.dco.ArticleCompositeObject;
import model.entitys.User;
import model.exception.NoMatchUserException;

public class ArticleEntrance implements Touchable {
	//private EntityManager em = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArticleEntrance() {

	}

	public void initializeEntityManager(String persistenceUnitName) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		//this.em = emf.createEntityManager();

	}

	@SuppressWarnings("unchecked")
	public void fillRecords(List<ArticleCompositeObject> records, EntityManager em) {
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
		
		em.close();

	}

	@Override
	public User execute(EntityManager em) throws NoMatchUserException {
		// TODO Auto-generated method stub
		return null;
	}
}
