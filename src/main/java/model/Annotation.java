package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Annotation")
@NamedQueries({
	@NamedQuery(name="findByName",query="SELECT a from Annotation a where a.name=:name"),
	@NamedQuery(name="getAnnotationByBook", query = "SELECT a FROM Annotation a WHERE a.book.id=:idBook"),
	@NamedQuery(name="getAnnotationByChapter", query = "SELECT a FROM Annotation a WHERE a.chapter.id=:idChapter")
	})
public class Annotation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chapterId")
	private Chapter chapter;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId")
	private Book book;

	public Annotation(String name, String description, Chapter chapter, Book book) {
		this.id = -1L;
		this.name = name;
		this.description = description;
		this.chapter = chapter;
		this.book = book;
	}

	public Annotation() {
		this("", "", new Chapter(), new Book());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Annotation [id=" + id + ", name=" + name + ", description=" + description + /*", chapter=" + chapter + ", book=" + book +*/ "]";
	}

}
