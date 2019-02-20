package model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.entitys.Article;
import model.manager.ArticleManager;
import model.manager.IDEArticleEntrance;
import model.manager.JPAArticleEntrance;
import model.manager.JSFArticleEntrance;
import model.manager.StorageManager;

@ManagedBean(name = "ideTutorialPage")
@RequestScoped
public class IdeTutorialContentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArticleManager artMan = null;
	
	public IdeTutorialContentBean() {
		
	}
	
	@PostConstruct
	public void initialize() {
		StorageManager storMan = new StorageManager();
		artMan = new ArticleManager();
		
	}
	
	public List<Article> getIDEArticles(){
		artMan.setArticleEntrance(new IDEArticleEntrance());
		
		return artMan.fillRecords(StorageManager.getEntityManager());
	}
	
	public List<Article> getJPAArticles(){
		artMan.setArticleEntrance(new JPAArticleEntrance());
		
		return artMan.fillRecords(StorageManager.getEntityManager());
	}
	
	public List<Article> getJSFArticles() {
		artMan.setArticleEntrance(new JSFArticleEntrance());
		
		return artMan.fillRecords(StorageManager.getEntityManager());
		
	}
}
