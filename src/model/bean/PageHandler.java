package model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import model.dco.ArticleCompositeObject;
import model.manager.ArticleEntrance;
import model.manager.StorageManager;

@ManagedBean
@RequestScoped
public class PageHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArticleEntrance artEntrancer = new ArticleEntrance();
	private List<ArticleCompositeObject> records = new ArrayList<ArticleCompositeObject>();

	public PageHandler() {

	}

	@PostConstruct
	public void initialize() {
		// artEntrancer.initializeEntityManager("net.software-development");
		StorageManager storMag = new StorageManager();
		EntityManager em = StorageManager.getEntityManager();
		artEntrancer.fillRecords(records, em);
	}

	public List<ArticleCompositeObject> getSections() {
		return records;
	}

	public void setSections(List<ArticleCompositeObject> records) {
		this.records = records;
	}
}
