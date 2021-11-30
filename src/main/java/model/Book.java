package model;

import java.util.Set;

public class Book {
	private Integer id;
	private String nombre;
	private Author autor;
	private Set<Character> characterList;
	
	public Book(Integer id, String nombre, Author autor, Set<Character> characterList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.characterList = characterList;
	}
	public Book() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Author getAutor() {
		return autor;
	}
	public void setAutor(Author autor) {
		this.autor = autor;
	}
	public Set<Character> getCharacterList() {
		return characterList;
	}
	public void setCharacterList(Set<Character> characterList) {
		this.characterList = characterList;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", characterList=" + characterList + "]";
	}
}
