package control;

import java.io.Serializable;
import java.util.Enumeration;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "pageHandler")
@RequestScoped
public class PageController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	private String outcome;
	private String loginValue;
	private String loginOutcome;

	public PageController() {
		this.value = "Benutzerkonto erstellen";
		this.outcome = "/createAccount.jsf";
		this.loginValue = "Anmelden";
		this.loginOutcome = "/login.jsf";
	}

	@PostConstruct
	public void initialize() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		if(session.getAttribute("username") != null) {
			value = "Abmelden";
			outcome = "/logout.jsf";
			loginValue = (String)session.getAttribute("username");
			loginOutcome = "/userSettings.jsf";
		}
		
	}

	public String getValue() {
		return value;
	}

	public String getOutcome() {
		return outcome;
	}

	public String getLoginValue() {
		return loginValue;
	}

	public String getLoginOutcome() {
		return loginOutcome;
	}

}
