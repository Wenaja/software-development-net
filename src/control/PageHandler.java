package control;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import control.content.MenuController;
import control.content.Submenu;
import control.content.TopMenu;
import control.content.exception.NotSupportedOperationException;

@ManagedBean
@RequestScoped
public class PageHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuController menCon = null;
	MenuController topMenu = null;
	
	public PageHandler() {
		
	}
	
	@PostConstruct
	public void initialize() {
		this.menCon = new TopMenu();
		
		TopMenu startseite = new TopMenu();
		startseite.add(new Submenu("Startseite", "/home.jsf"));
		startseite.add(new Submenu("Über mich", "/aboutMe.jsf"));
		startseite.add(new Submenu("Kontakt", "/contact.jsf"));
		
		TopMenu tutorials = new TopMenu();
		tutorials.add(new Submenu("IDE", "/ide-tutorial.jsf"));
		tutorials.add(new Submenu("JSF", "/jsf-tutorial.jsf"));
		tutorials.add(new Submenu("JPA", "/jpa-tutorial.jsf"));
		
		TopMenu webApps = new TopMenu();
		webApps.add(new Submenu("EVA", "/eva.jsf"));
		webApps.add(new Submenu("AbRe", "/abre.jsf"));
		webApps.add(new Submenu("LotRe", "/lotre.jsf"));
		
		try{ 
			menCon.add(startseite);
			menCon.add(tutorials);
			menCon.add(webApps);
		} catch (NotSupportedOperationException e) {
			
		}
		
		
	}
	
	public String putStartseiteOutcome() {
		topMenu = menCon.getElement(0);
		
		return "/home.jsf";
	}
	
	public String putTutorialsOutcome() {
		topMenu = menCon.getElement(1);
		
		return "/ide-tutorial.jsf";
	}
	
	public String writeMenuOneValue() {
		return topMenu.getElement(0).getValue();
		
	}
	
	public String writeMenuTwoValue() {
		return topMenu.getElement(1).getValue();
		
	}
	
	public String writeMenuThreeValue() {
		return topMenu.getElement(2).getValue();
		
	}

}
