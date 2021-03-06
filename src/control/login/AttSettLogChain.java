package control.login;

import javax.servlet.http.HttpSession;

import control.login.exception.LoginFailureException;
import model.entitys.User;
import model.manager.AttributeSetter;
import model.manager.Touchable;

public class AttSettLogChain extends LoginChain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String pwd;

	public AttSettLogChain(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	@Override
	public Touchable getTouchable(HttpSession session, User user) throws LoginFailureException {
		if (user.getActive()) {
			return new AttributeSetter(user.getId());
		}

		throw new LoginFailureException("Ihr Benutzerkonto wurde deaktiviert. Mit allen Fragen wenden Sie sich an den Anministrator.");
	}

}
