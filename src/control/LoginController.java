package control;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	public void verifyLogin() {
		try {
			HttpSession session = getSession(getExtContext());
			if (!isLogged(session)) {
				doRedirect("login.jsf");
			}
		} catch (Exception e) {
			doRedirect("login.jsf");
		}
	}

	private ExternalContext getExtContext() {

		FacesContext fc = FacesContext.getCurrentInstance();

		return fc.getExternalContext();
	}

	private HttpSession getSession(ExternalContext ec) throws Exception {
		HttpSession session = (HttpSession) ec.getSession(false);

		if (session == null) {
			throw new Exception();
		}

		return session;
	}

	private boolean isLogged(HttpSession session) {
		boolean active = false;

		if (session.getAttribute("active") != null) {
			active = (boolean) session.getAttribute("active");
		}

		return active;
	}

	private void doRedirect(String url) {
		ExternalContext extContext = getExtContext();

		try {
			extContext.redirect(url);
		} catch (IOException e) {
			// missing function
		}
	}

}
