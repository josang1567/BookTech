package model;

public class Author {
	private Integer id;
	private String name;
	private String web_page;
	private String email;
	private String password;

	public Author(Integer id, String name, String web_page, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.web_page = web_page;
		this.email = email;
		this.password = password;
	}

	public Author() {
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

	public String getWeb_page() {
		return web_page;
	}

	public void setWeb_page(String web_page) {
		this.web_page = web_page;
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", web_page=" + web_page + ", email=" + email + ", password="
				+ password + "]";
	}
}