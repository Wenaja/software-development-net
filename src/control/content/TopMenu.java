package control.content;

import java.util.ArrayList;
import java.util.List;

public class TopMenu extends MenuController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<MenuController> menCon = new ArrayList<MenuController>();
	
	public TopMenu() {
		
	}
	
	@Override 
	public void add(MenuController item) {
		menCon.add(item);
	}
	
	@Override 
	public void delete(MenuController item) {
		menCon.remove(item);
	}
	
	@Override
	public MenuController getElement(int index) {
		return menCon.get(index);
	}

	@Override
	public String getValue() {
		
		return null;
	}

	@Override
	public String getOutcome() {
		
		return null;
	}

}
