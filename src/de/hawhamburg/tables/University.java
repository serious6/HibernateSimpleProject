/*
 * 
 */
package de.hawhamburg.tables;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Table;

/**
 * The Class University.
 */
@Entity(name = "UNIVERSITY")
@Table(appliesTo = "UNIVERSITY")
public class University implements Serializable {
	private static final long serialVersionUID = 445920794797949818L;

	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne()
	@Cascade({ CascadeType.SAVE_UPDATE })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Adress adress;

	@OneToMany()
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.PERSIST })
	private final Set<Student> students = new HashSet<>();

	public University() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

}
