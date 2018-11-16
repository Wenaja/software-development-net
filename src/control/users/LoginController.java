package control.users;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javax.servlet.http.HttpSession;

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
		this.emf = Persistence.createEntityManagerFactory("net.software-development");
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
		
		
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> ls = query.getResultList();
		
		for(User u : ls) {
			if(email.equals(u.getEmail()) && pwd.equals(u.getPwd())) {
				if(!"null".equals(u.getSessionID())) {
					return "home?faces-redirect=true";
				}
				
				javax.faces.context.FacesContext fc = javax.faces.context.FacesContext.getCurrentInstance();
				javax.faces.context.ExternalContext ec = fc.getExternalContext();
				HttpSession session = null;
				session = (HttpSession)ec.getSession(false);
				if(session != null) {
					em.getTransaction().begin();
					u.setSessionID(session.getId());
					em.getTransaction().commit();
				}
				return "home?faces-redirect=true";
			}
		}
		
		// Miss messge
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Loginn fail", "User oder Password is not ok"));
		
		return "login";
	}
}
