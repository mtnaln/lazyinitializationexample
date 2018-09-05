package domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	private String name;

	private String surname;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private List<Course> courses;

	public Student(){

	}

	public Student(Long id, String name, String surname, List<Course> courses) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.courses = courses;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
