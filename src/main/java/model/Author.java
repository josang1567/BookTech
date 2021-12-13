package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
@NamedQueries({
	@NamedQuery(name="findAuthorbyName",query="SELECT b from Author b where b.name=:name"),
	@NamedQuery(name="findUserPassword",query="SELECT a from Author a where a.name=:name AND a.password= :password")
})
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Author singletoon;
	
	public static Author get_Instance() {
		if(singletoon==null) {
			singletoon=new Author();	
		}	
		return singletoon;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "website")
	private String website;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Book> books;

	public Author(String name, String website, String email, String password, Set<Book> books) {
		this.id = -1L;
		this.name = name;
		this.website = website;
		this.email = email;
		this.password = password;
		this.books = books;
	}

	public Author() {
		this("", "", "", "", new HashSet<Book>());
	}
	
	public Author(String usuario,String password) {
		this.name=usuario;
		this.password=password;
	}
	
	
	
	public Author(String name, String website, String email, String password) {
		this(name, website, email, password, new HashSet<Book>());
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

	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", website=" + website + ", email=" + email + ", password=" + password + /*", books=" + books +*/ "]";
	}
}