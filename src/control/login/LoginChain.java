package control.login;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import control.login.exception.LoginFailureException;
import model.entitys.User;
import model.manager.StorageManager;
import model.manager.Touchable;

public abstract class LoginChain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginChain next = null;

	public void setNextChain(LoginChain next) {
		this.next = next;
	}

	public LoginChain getNextChain() {
		return next;
	}

	public void runChainThrough(StorageManager storageManager, HttpSession session, User user)
			throws LoginFailureException {
		storageManager.setNextOperation(getTouchable(session, user));
		user = storageManager.execute(StorageManager.getEntityManager());

		if (next != null) {
			next.runChainThrough(storageManager, session, user);
		}

	}

	abstract Touchable getTouchable(HttpSession session, User user) throws LoginFailureException;

}
