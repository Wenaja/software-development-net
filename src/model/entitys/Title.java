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
 * The persistent class for the titles database table.
 * 
 */
@Entity
@Table(schema="k39752uz_articlesDB", name="titles")
@NamedQuery(name="Title.findAll", query="SELECT t FROM Title t")
public class Title implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="caption")
	private String caption;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="title", fetch = FetchType.LAZY)
	private Set<Article> articls;

	public Title() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Set<Article> getArticls() {
		return this.articls;
	}

	public void setArticls(Set<Article> articls) {
		this.articls = articls;
	}

	public Article addArticl(Article articl) {
		if(getArticls() == null) {
			setArticls(new HashSet<Article>());
		}
		getArticls().add(articl);
		articl.setTitle(this);

		return articl;
	}

	public Article removeArticl(Article articl) {
		if(getArticls() == null) {
			setArticls(new HashSet<Article>());
		}
		getArticls().remove(articl);
		articl.setTitle(null);

		return articl;
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
		Title other = (Title) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", caption=" + caption + "]";
	}

}