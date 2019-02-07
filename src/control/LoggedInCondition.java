package control;

public class LoggedInCondition implements LoggedCondition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getValue() {
		return "Hier muss username stehen";
	}
	
	public String getOutcome() {
		return "Hier muss die Adresse zur Seite mit user-settings sein";
	}

}
