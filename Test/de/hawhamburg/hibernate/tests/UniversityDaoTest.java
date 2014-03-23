package de.hawhamburg.hibernate.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hawhamburg.hibernate.dao.UniversityDao;
import de.hawhamburg.tables.Adress;
import de.hawhamburg.tables.Student;
import de.hawhamburg.tables.University;

public class UniversityDaoTest {

	private UniversityDao universityDao;

	@Before
	public void setUp() throws Exception {
		this.universityDao = new UniversityDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addUniversity() {
		University university = new University();
		university.setName("TUHH");
		university.setAdress(new Adress("Schwarzenbergstraﬂe", "93", "21073",
				"Hamburg"));

		universityDao.add(university);
		Assert.assertNotNull(university.getId());
	}

	@Test
	public void populateUniversity() {
		University haw = new University();
		haw.setName("HAW Hamburg");
		haw.setAdress(new Adress("Berliner Tor", "5", "20099", "Hamburg"));

		Adress wg1 = new Adress("Jungfernstieg", "1", "20099", "Hamburg");
		Student student1 = new Student();
		student1.setAdress(wg1);
		student1.setFirstName("Paul");
		student1.setLastName("Paulsen");

		Student student2 = new Student();
		student2.setAdress(wg1);
		student2.setFirstName("Paulina");
		student2.setLastName("Paulinsen");

		universityDao.add(haw);
	}

}
