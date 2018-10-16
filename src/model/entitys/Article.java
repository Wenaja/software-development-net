package model.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the articles database table.
 * 
 */
@Entity
@Table(schema="k39752uz_articlesDB", name="articles")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="active")
	private Byte active;

	@Column(name="article")
	private String article;

	@Temporal(TemporalType.TIMESTAMP)
	private Date published;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category")
	private Category category;

	//bi-directional many-to-one association to Title
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="title")
	private Title title;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="article", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	public Article() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getArticle() {
		return this.article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Date getPublished() {
		return this.published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		if(getComments() == null) {
			setComments(new HashSet<Comment>());
		}
		getComments().add(comment);
		comment.setArticle(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		if(getComments() == null) {
			setComments(new HashSet<Comment>());
		}
		getComments().remove(comment);
		comment.setArticle(null);

		return comment;
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
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", active=" + active + ", published=" + published + ", category=" + category
				+ ", title=" + title + "]";
	}

}