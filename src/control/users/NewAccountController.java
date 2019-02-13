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
		
	}
	
	@PostConstruct
	private void initilize() {
		user = new UserCompositeObject();
		this.emf = Persistence.createEntityManagerFactory("net.software-development");
		em = emf.createEntityManager();
	}

	public UserCompositeObject getUser() {
		return user;
	}

	public void setUser(UserCompositeObject user) {
		this.user = user;
	}
	
	private boolean isUserExist() {
		TypedQuery<String> query = em.createQuery("SELECT u.email FROM User u", String.class);
		
		List<String> ls = query.getResultList();
		
		for(String email : ls) {
			if(email.equals(user.getEmail())) {
				return true;
			}
		}
		
		return false;
	}
	
	public String foo() {
		System.out.println("Vom Formular an den Server angekommen: ");
		System.out.println("Vorname: " + user.getForename());
		System.out.println("Nachname: " + user.getSurname());
		System.out.println("Benutzername: " + user.getUsername());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Erstes Kennwort: " + user.getFirst_password());
		System.out.println("zweites Kennwort: " + user.getSecond_password());
		
		return "home";
		
		/*if(!isUserExist()) {
			User youngUser = new User();
			
			youngUser.setForename(user.getForename());
			youngUser.setSurname(user.getSurname());
			youngUser.setUsername(user.getUsername());
			youngUser.setEmail(user.getEmail());
			youngUser.setActive(new Boolean(false));
			youngUser.setPwd(user.getSecond_password());
			
			em.getTransaction().begin();
			em.persist(youngUser);
			em.getTransaction().commit();
			
			return "NewAccountErgs";
		}else {
			return "NewAccountFail";
		}*/
		
	}
}
