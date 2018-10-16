package control.users;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
@SessionScoped
public class LoginController {
	private User user;

	EntityManager em;

	public LoginController() {
		user = new User();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("net.software-development");
		em = emf.createEntityManager();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@SuppressWarnings("unchecked")
	public String printArticle() {
		String statja = "";
		Query q = em.createQuery("SELECT a.article FROM Article a WHERE a.id=1");
		List<String> ls = (List<String>) q.getResultList();

		for (String s : ls) {
			statja = s;
		}
		return statja;
	}
}
