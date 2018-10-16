package model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.dco.ArticleCompositeObject;
import model.manager.ArticleEntrance;

@ManagedBean
@RequestScoped
public class PageHandler {
	private ArticleEntrance artEntrancer = new ArticleEntrance();
	private List<ArticleCompositeObject> records = new ArrayList<ArticleCompositeObject>();

	public PageHandler() {

	}

	@PostConstruct
	public void initialize() {
		artEntrancer.initializeEntityManager("net.software-development");
		artEntrancer.fillRecords(records);
	}

	public List<ArticleCompositeObject> getSections() {
		return records;
	}

	public void setSections(List<ArticleCompositeObject> records) {
		this.records = records;
	}
}
