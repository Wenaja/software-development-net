package model.entitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(schema="k39752uz_articlesDB", name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="articlecategory")
	private String articlecategory;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="category", fetch = FetchType.LAZY)
	private Set<Article> articles;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArticlecategory() {
		return this.articlecategory;
	}

	public void setArticlecategory(String articlecategory) {
		this.articlecategory = articlecategory;
	}

	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		if(getArticles() == null) {
			setArticles(new HashSet<Article>());
		}
		getArticles().add(article);
		article.setCategory(this);

		return article;
	}

	public Article removeArticle(Article article) {
		if(getArticles() == null) {
			setArticles(new HashSet<Article>());
		}
		getArticles().remove(article);
		article.setCategory(null);

		return article;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", articlecategory=" + articlecategory + "]";
	}

}