package de.hawhamburg.hibernate.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hawhamburg.hibernate.dao.AdressDao;
import de.hawhamburg.tables.Adress;

public class AdressDaoTest {

	private AdressDao adressDao;

	@Before
	public void setUp() throws Exception {
		this.adressDao = new AdressDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Adress adress = new Adress("Winsener Str", "137", "22055", "Hamburg");

		adressDao.add(adress);
		Assert.assertNotNull(adress.getId());
	}

}
