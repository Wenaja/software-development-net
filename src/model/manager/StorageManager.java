package model.manager;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import control.login.exception.LoginFailureException;
import model.entitys.User;
import model.exception.NoMatchUserException;

public class StorageManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("net.software-development");

	Touchable storage;

	public StorageManager() {

	}

	public StorageManager(Touchable storage) {
		this.storage = storage;
	}

	public User execute(EntityManager em) throws LoginFailureException {
		User user = null;

		try {
			user = storage.execute(em);
			
			if(em.isOpen())
				em.close();
			
			return user;
			
		} catch (NoMatchUserException e) {
			if(em.isOpen())
				em.close();
			throw new LoginFailureException(e.getMessage());
		}

	}

	public void setNextOperation(Touchable storage) {
		this.storage = storage;
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();

	}

}
