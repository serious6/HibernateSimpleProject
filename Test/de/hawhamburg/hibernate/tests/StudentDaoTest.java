package de.hawhamburg.hibernate.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hawhamburg.hibernate.dao.StudentDao;
import de.hawhamburg.tables.Adress;
import de.hawhamburg.tables.Student;

public class StudentDaoTest {

	private StudentDao studentDao;

	@Before
	public void setUp() throws Exception {
		studentDao = new StudentDao();
	}

	@Test
	public void addStudent() {
		Student student = new Student();
		student.setFirstName("Felix");
		student.setLastName("Tester");

		student.setAdress(new Adress("Teststraße", "12a", "99999",
				"Musterhausen"));

		studentDao.add(student);
		assertNotNull(student.getId());
	}

	@Test
	public void updateStudent() {
		Student student = new Student();
		student.setFirstName("Update");
		student.setLastName("Tester");
		student.setAdress(new Adress("Teststraße", "12a", "99999",
				"Musterhausen"));

		studentDao.add(student);
		assertNotNull(student.getId());

		String changedName = "ChangedName";

		student.setFirstName(changedName);
		studentDao.update(student);

		Student updatedStudent = studentDao.findById(student.getId());
		assertNotNull(updatedStudent);

		assertEquals(changedName, updatedStudent.getFirstName());
	}

	@Test
	public void criteriaTest() {
		Student base = new Student();
		base.setFirstName("Alex");
		base.setAdress(new Adress("Teststraße", "1a", "99998", "Musterhausen"));
		studentDao.add(base);

		List<Student> students = studentDao.selectAllStudentsWithoutUni();
		assertNotNull(students);
		assertTrue(students.size() > 0);
	}

	@Test
	public void findStudentThatIsNotThere() {
		Student student = studentDao.findById(Long.MAX_VALUE);
		assertNull(student);
	}

	@Test
	public void findStudent() {
		Student base = new Student();
		base.setFirstName("Max");
		base.setAdress(new Adress("Teststraße", "1a", "99998", "Musterhausen"));
		studentDao.add(base);

		assertNotNull(base.getId());

		Student student = studentDao.findById(base.getId());
		assertNotNull(student);

		assertEquals("Max", student.getFirstName());
		assertEquals(base.getId(), student.getId());
	}

	@Test
	public void deleteStudent() {
		Student anna = new Student();
		anna.setFirstName("Anna");
		anna.setAdress(new Adress("Teststraße", "1a", "99998", "Musterhausen"));

		studentDao.add(anna);

		studentDao.remove(anna);

		assertNull(studentDao.findById(anna.getId()));
	}

}
