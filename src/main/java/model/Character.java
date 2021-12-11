package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Characters")
@NamedQueries({
	@NamedQuery(name="findNameByBookCharacters",query="SELECT a from Character a where a.name=:name"),
	})
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "rol")
	private String rol;
	@Column(name = "characteristics")
	private String characteristics;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Book> books;

	public Character(String name, String rol, String characteristics, Set<Book> books) {
		this.id = -1L;
		this.name = name;
		this.rol = rol;
		this.characteristics = characteristics;
		this.books = books;
	}

	public Character() {
		this("", "", "", new HashSet<Book>());
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

	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", rol=" + rol + ", characteristics=" + characteristics + ", books=" + books + "]";
	}

}
