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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Part")
@NamedQueries({
	@NamedQuery(name="findNameByPart",query="SELECT a from Part a where a.name=:name"),
	@NamedQuery(name="getAll",query="SELECT p FROM Part p"),
	@NamedQuery(name="getPartByBook", query = "SELECT p FROM Part p WHERE p.book.id=:idBook")
})
public class Part implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Part singletoon;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "number")
	private Integer number;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId")
	private Book book;
	@OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Chapter> chapters;

	public Part(String name, Integer number, Book book, Set<Chapter> chapters) {
		this.id = -1L;
		this.name = name;
		this.number = number;
		this.book = book;
		this.chapters = chapters;
	}
	
	public static Part get_Instance() {
		if(singletoon==null) {
			singletoon=new Part();	
		}	
		return singletoon;
	}

	public Part() {
		this("", Integer.MIN_VALUE, new Book(), new HashSet<Chapter>());
	}

	public Part(String name, Integer number, Book book) {
		this(name, number, book, new HashSet<Chapter>());
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

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public Set<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", number=" + number + /*", book=" + book + ", chapters=" + chapters +*/ "]";
	}
}
