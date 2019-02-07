package control;

public class LoggedOutCondition implements LoggedCondition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getValue() {
		return "Anmelden";
		
	}
	
	public String getOutcome() {
		return "Benutzerkonto erstellen";
	}

}
