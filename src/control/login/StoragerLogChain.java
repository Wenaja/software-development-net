package control.login;

import javax.servlet.http.HttpSession;

import control.login.exception.LoginFailureException;
import model.entitys.User;
import model.manager.Storager;
import model.manager.Touchable;

public class StoragerLogChain extends LoginChain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String pwd;

	public StoragerLogChain(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;

	}

	@Override
	public Touchable getTouchable(HttpSession session, User user) throws LoginFailureException {
		if (pwd.equals(user.getPwd())) {
			return new Storager(user.getId(), session.getId());
		}

		throw new LoginFailureException("Das von Ihnen eingegebenen Kennwort ist falsch!");
	}

}
