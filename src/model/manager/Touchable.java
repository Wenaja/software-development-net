package model.manager;

import java.io.Serializable;

import javax.persistence.EntityManager;

import model.entitys.User;
import model.exception.NoMatchUserException;

public interface Touchable extends Serializable {
	User execute(EntityManager em) throws NoMatchUserException;

}
