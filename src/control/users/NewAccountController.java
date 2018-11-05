package control.users;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.dco.UserCompositeObject;
import model.entitys.User;

@ManagedBean
@SessionScoped
public class NewAccountController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserCompositeObject user = null;
	private EntityManagerFactory emf;
	private EntityManager em;

	public NewAccountController() {
		user = new UserCompositeObject();
	}
	
	@PostConstruct
	private void initilize() {
		this.emf = Persistence.createEntityManagerFactory("net.software-development");
		em = emf.createEntityManager();
	}

	public UserCompositeObject getUser() {
		return user;
	}

	public void setUser(UserCompositeObject user) {
		this.user = user;
	}
	
	public String foo() {
		User youngUser = new User();
		
		youngUser.setForename(user.getForename());
		youngUser.setSurname(user.getSurname());
		youngUser.setUsername(user.getUsername());
		youngUser.setEmail(user.getEmail());
		youngUser.setActive(new Byte("0"));
		youngUser.setPwd(user.getSecond_password());
		
		em.getTransaction().begin();
		em.persist(youngUser);
		em.getTransaction().commit();
		
		return "NewAccountErgs";
	}
}
