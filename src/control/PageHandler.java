package control;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "pageHandler")
@RequestScoped
public class PageHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	private String outcome;
	private String loginValue;
	private String loginOutcome;

	public PageHandler() {

	}

	@PostConstruct
	public void initialize() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		try {
			value = "Abmelden";
			outcome = "/userSettings.jsf";
			loginValue = (String) session.getAttribute("username");
			loginOutcome = "/userSettings.jsf";
		} catch(NullPointerException e) {
			value = "Benutzerkonto erstellen";
			outcome = "/createAccount.jsf";
			loginValue = "Anmelden";
			loginOutcome = "/login.jsf";
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
