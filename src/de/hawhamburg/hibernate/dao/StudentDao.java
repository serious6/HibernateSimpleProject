package de.hawhamburg.hibernate.dao;

import de.hawhamburg.tables.Student;

public class StudentDao extends GenericDao<Student> {

	public StudentDao() {
		super(Student.class);
	}
}
