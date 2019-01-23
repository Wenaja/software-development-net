package model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import model.entitys.Article;
import model.manager.IDEArticleEntrance;
import model.manager.StorageManager;

@ManagedBean
@RequestScoped
public class ContentHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDEArticleEntrance artEntrancer = new IDEArticleEntrance(new ArrayList<Article>());
	private List<Article> records = null;

	public ContentHandler() {

	}

	@PostConstruct
	public void initialize() {
		// artEntrancer.initializeEntityManager("net.software-development");
		StorageManager storMag = new StorageManager();
		EntityManager em = StorageManager.getEntityManager();
		// artEntrancer.fillRecords(new ArrayList<ArticleCompositeObject>(), em);
		records = artEntrancer.fillRecords(em);
		
		if(em.isOpen())
			em.close();
		
	}

	public List<Article> getSections() {
		return records;
	}

	public void setSections(List<Article> records) {
		this.records = records;
	}
}
