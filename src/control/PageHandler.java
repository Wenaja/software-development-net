package control;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "pageHandler")
@RequestScoped
public class PageHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PageHandler() {
		
	}
	
	@PostConstruct
	public void initialize() {
		
	}
	
	public String putStartseiteOutcome(String item) {
		System.out.println("bin in putStartseiteOutcome " + item);
		
		return "/home.jsf";
	}
	
	public String putTutorialsOutcome(String item) {
		System.out.println("bin in putTutorialsOutcome " + item);
		
		return "/ide-tutorial.jsf";
	}
	
	public String putWebAppsOutcome(String item) {
		System.out.println("bin in putWebAppsOutcome " + item);
		
		return "/webApps.jsf";
	}
	
	public String writeMenuOneValue() {
		return "Startseite";
	}
	
	public String writeMenuTwoValue() {
		return "Tutorials";
	}
	
	public String writeMenuThreeValue() {
		return "Web Applikationen";
	}
	
	public String writeSubMenuOneValue() {
		System.out.println("bin in writeMenuOneValue");
		return "Startseite";
		
	}
	
	public String writeSubMenuTwoValue() {
		System.out.println("bin in writeMenuTwoValue");
		return "Tutorials";
		
	}
	
	public String writeSubMenuThreeValue() {
		System.out.println("bin in writeMenuThreeValue");
		return "Web Applikationen";
		
	}
	
	public String writeSubMenuOneOutcome() {
		System.out.println("bin in writeMenuOneOutcome");
		return "/home.jsf";
	}
	
	public String writeSubMenuTwoOutcome() {
		System.out.println("bin in writeMenuTwoOutcome");
		return "/ide-tutorial.jsf";
	}
	
	public String writeSubMenuThreeOutcome() {
		System.out.println("bin in writeMenuThreeOutcome");
		return "webApps.jsf";
	}

}
