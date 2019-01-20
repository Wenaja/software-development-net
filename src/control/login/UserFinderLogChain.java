package control.login;

import javax.servlet.http.HttpSession;

import control.login.exception.LoginFailureException;
import model.entitys.User;
import model.manager.Touchable;
import model.manager.UserFinder;

public class UserFinderLogChain extends LoginChain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String pwd;

	public UserFinderLogChain(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;

	}

	@Override
	public Touchable getTouchable(HttpSession session, User user) throws LoginFailureException {
		if (!email.isEmpty()) {
			return new UserFinder(email);
		}

		throw new LoginFailureException("Bitte, geben Sie Ihre Email-Adresse ein!");
	}

}
