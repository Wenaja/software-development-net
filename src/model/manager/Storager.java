package model.manager;

import javax.persistence.EntityManager;

import model.entitys.User;
import model.exception.NoMatchUserException;

public class Storager implements Touchable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String session_id;

	public Storager(Integer user_id, String session_id) {
		this.user_id = user_id;
		this.session_id = session_id;
	}

	@Override
	public User execute(EntityManager em) throws NoMatchUserException {
		User user = em.find(User.class, user_id);

		em.getTransaction().begin();
		user.setSessionID(session_id);
		em.getTransaction().commit();

		em.refresh(user);
		em.close();

		return user;
	}

}
