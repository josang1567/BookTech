package model;

public class Chapter {
	private int id;
	private String nombre;
	private int number;
	private String descripcion;
	private Part part;

	public Chapter(int id, String nombre, int number, String descripcion, Part part) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.number = number;
		this.descripcion = descripcion;
		this.part = part;
	}

	public Chapter() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", nombre=" + nombre + ", number=" + number + ", descripcion=" + descripcion
				+ ", part=" + part + "]";
	}
}
