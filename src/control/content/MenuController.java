package control.content;

import java.io.Serializable;

import control.content.exception.NotSupportedOperationException;

public abstract class MenuController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract void add(MenuController item) throws NotSupportedOperationException;
	
	public abstract void delete(MenuController item) throws NotSupportedOperationException;
	
	public abstract MenuController getElement(int index);
	
	public abstract String getValue();
	
	public abstract String getOutcome();

}
