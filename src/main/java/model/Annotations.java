package model;

public class Annotations {
	private Integer id;
	private String name;
	private String description;
	private Book book;
	private Chapter chapter;

	public Annotations(Integer id, String name, String description, Book book, Chapter chapter) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.book = book;
		this.chapter = chapter;
	}

	public Annotations() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "Annotations [id=" + id + ", name=" + name + ", description=" + description + ", book=" + book
				+ ", chapter=" + chapter + "]";
	}
}
