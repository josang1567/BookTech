package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
@NamedQueries({
	@NamedQuery(name="findNameByBook",query="SELECT a from Book a where a.name=:name"),
	})
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "authorId")
	private Author author;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Part> parts;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Annotation> annotations;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Character> characters;

	public Book(String name, Author author, Set<Part> parts, Set<Annotation> annotations, Set<Character> characters) {
		this.id = -1L;
		this.name = name;
		this.author = author;
		this.parts = parts;
		this.annotations = annotations;
		this.characters = characters;
	}

	public Book() {
		this("", new Author(), new HashSet<Part>(), new HashSet<Annotation>(), new HashSet<Character>());
	}
	
	public Book(String name, Author author) {
		this(name, author, new HashSet<Part>(), new HashSet<Annotation>(), new HashSet<Character>());
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

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Part> getParts() {
		return parts;
	}
	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}

	public Set<Annotation> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations = annotations;
	}

	public Set<Character> getCharacters() {
		return characters;
	}
	public void setCharacters(Set<Character> characters) {
		this.characters = characters;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + /*", author=" + author + ", parts=" + parts + ", annotations=" + annotations + ", characters=" + characters +*/ "]";
	}

}
