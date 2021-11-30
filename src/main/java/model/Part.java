package model;

public class Part {
	private Integer id;
	private String name;
	private Book book;
	private Integer number;

	public Part(Integer id, String name, Book book, Integer number) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
		this.number = number;
	}

	public Part() {
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", book=" + book + ", number=" + number + "]";
	}
}
