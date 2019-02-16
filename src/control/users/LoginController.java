package control.users;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import control.login.AttSettLogChain;
import control.login.LoginChain;
import control.login.StoragerLogChain;
import control.login.UserFinderLogChain;
import control.login.exception.LoginFailureException;
import model.entitys.User;
import model.manager.StorageManager;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String pwd;

	public LoginController() {

	}

	public String makeLogin() {
		System.out.println("Ich mache gerade login mit diesem password: " + pwd);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		StorageManager storageManager = new StorageManager();

		LoginChain log = new UserFinderLogChain(email, pwd);
		log.setNextChain(new StoragerLogChain(email, pwd));
		log.getNextChain().setNextChain(new AttSettLogChain(email, pwd));

		try {
			log.runChainThrough(storageManager, session, new User());
		} catch (LoginFailureException e) {
			// Miss messge
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "verstehe nicht wozu das hier dient?"));
			
			return "login?faces-redirect=true";
		}

		return "home?faces-redirect=true";
	}
	
	public String makeLogout() {
		// man sollte Session in DB deleten und.. evtl session-Variable reseten
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("net.sofware-development");
		EntityManager em = emf.createEntityManager();
		Integer userId = (Integer)session.getAttribute("user_id");
		User user = em.find(User.class, userId);
		
		em.getTransaction().begin();
		user.setSessionID(null);
		em.getTransaction().commit();
		em.close();
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "home";
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
