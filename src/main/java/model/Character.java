package model;

import java.util.Set;

public class Character {
	private Integer id;
	private String name;
	private String rol;
	private String features;
	private Book book;
	private Set<Character> characterList;

	public Character(Integer id, String name, String rol, String features, Book book, Set<Character> characterList) {
		super();
		this.id = id;
		this.name = name;
		this.rol = rol;
		this.features = features;
		this.book = book;
		this.characterList = characterList;
	}

	public Character() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Set<Character> getCharacterList() {
		return characterList;
	}

	public void setCharacterList(Set<Character> characterList) {
		this.characterList = characterList;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", rol=" + rol + ", features=" + features + ", book=" + book
				+ ", characterList=" + characterList + "]";
	}
}
