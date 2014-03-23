package de.hawhamburg.hibernate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.hawhamburg.hibernate.tests.AdressDaoTest;
import de.hawhamburg.hibernate.tests.StudentDaoTest;
import de.hawhamburg.hibernate.tests.UniversityDaoTest;

@RunWith(Suite.class)
@SuiteClasses({ AdressDaoTest.class, StudentDaoTest.class,
		UniversityDaoTest.class })
public class AllTests {

}
