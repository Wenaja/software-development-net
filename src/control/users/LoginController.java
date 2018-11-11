package control.users;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.dco.LoginTransferObject;
import model.entitys.User;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private LoginTransferObject login;

	public LoginController() {
		
	}
	
	@PostConstruct
	public void initialize() {
		this.login = new LoginTransferObject();
		this.emf = Persistence.createEntityManagerFactory("");
		this.em = emf.createEntityManager();
	}

	public LoginTransferObject getLogin() {
		return login;
	}

	public void setLogin(LoginTransferObject login) {
		this.login = login;
	}

	public String makeLogin() {
		String email = login.getEmail();
		String pwd = login.getPwd();
		
		if(email == null && pwd == null) {
			return "";
		}
		
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> ls = query.getResultList();
		
		for(User u : ls) {
			if(email.equals(u.getEmail()) && pwd.equals(u.getPwd())) {
				return "";
			}
		}
		return "";
	}
}
