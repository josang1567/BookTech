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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Chapter")
public class Chapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "number")
	private Integer number;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "partId")
	private Part part;
	@OneToMany(mappedBy = "Chapter", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Annotation> annotations;

	public Chapter(String name, Integer number, String description, Part part, Set<Annotation> annotations) {
		this.id = -1L;
		this.name = name;
		this.number = number;
		this.description = description;
		this.part = part;
		this.annotations = annotations;
	}

	public Chapter() {
		this("", Integer.MIN_VALUE, "", new Part(), new HashSet<Annotation>());
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

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}

	public Set<Annotation> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations = annotations;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", number=" + number + ", description=" + description + ", part=" + part + ", annotations=" + annotations + "]";
	}
}
