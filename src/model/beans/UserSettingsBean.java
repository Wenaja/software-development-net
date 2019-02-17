package model.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "userSettings")
@RequestScoped
public class UserSettingsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String surname = "---";
	private String forename = "---";
	private String username = "---";
	private String email = "---";
	private String numberComments = "---";
	private String accountCreatedOn = "---";

	public UserSettingsBean() {

	}
	
	@PostConstruct
	public void initialize() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		if(session != null) {
			surname = (String)session.getAttribute("surname");
			forename = (String)session.getAttribute("forename");
			username = (String)session.getAttribute("username");
			email = (String)session.getAttribute("email");
			numberComments = "0";
			accountCreatedOn = "01.01.2018";
		}
	}

	public String getSurname() {
		return surname;
	}

	public String getForename() {
		return forename;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getNumberComments() {
		return numberComments;
	}

	public String getAccountCreatedOn() {
		return accountCreatedOn;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumberComments(String numberComments) {
		this.numberComments = numberComments;
	}

	public void setAccountCreatedOn(String accountCreatedOn) {
		this.accountCreatedOn = accountCreatedOn;
	}

}
