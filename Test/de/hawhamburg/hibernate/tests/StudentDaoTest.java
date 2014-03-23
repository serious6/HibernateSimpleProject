package de.hawhamburg.hibernate.tests;

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
		Assert.assertNotNull(student.getId());
	}

	@Test
	public void findStudentThatIsNotThere() {
		Student student = studentDao.findById(Long.MAX_VALUE);
		Assert.assertNull(student);
	}

	@Test
	public void findStudent() {
		Student base = new Student();
		base.setFirstName("Max");
		base.setAdress(new Adress("Teststraße", "1a", "99998", "Musterhausen"));
		studentDao.add(base);

		Assert.assertNotNull(base.getId());

		Student student = studentDao.findById(base.getId());
		Assert.assertNotNull(student);

		Assert.assertEquals("Max", student.getFirstName());
		Assert.assertEquals(base.getId(), student.getId());
	}

	@Test
	public void deleteStudent() {
		Student anna = new Student();
		anna.setFirstName("Anna");
		anna.setAdress(new Adress("Teststraße", "1a", "99998", "Musterhausen"));

		studentDao.add(anna);

		studentDao.remove(anna);

		Assert.assertNull(studentDao.findById(anna.getId()));
	}

}
