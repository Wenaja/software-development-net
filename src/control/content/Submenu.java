package control.content;

import control.content.exception.NotSupportedOperationException;

public class Submenu extends MenuController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String value;
	String outcome;
	
	public Submenu(String value, String outcome) {
		this.outcome = outcome;
		this.value = value;
	}
	
	@Override 
	public void add(MenuController item) throws NotSupportedOperationException {
		throw new NotSupportedOperationException();
	}
	
	@Override 
	public void delete(MenuController item) throws NotSupportedOperationException {
		throw new NotSupportedOperationException();
	}
	
	@Override 
	public MenuController getElement(int index) throws NotSupportedOperationException {
		throw new NotSupportedOperationException();
	}

	@Override
	public String getValue() {	
		return value;
	}

	@Override
	public String getOutcome() {
		return outcome;
	}

}
