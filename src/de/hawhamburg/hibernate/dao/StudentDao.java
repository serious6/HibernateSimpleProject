package de.hawhamburg.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import de.hawhamburg.tables.Student;

public class StudentDao extends GenericDao<Student> {

	public StudentDao() {
		super(Student.class);
	}

	public List<Student> selectAllStudentsWithoutUni() {
		Session session = getTransaction();

		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.isNull("university"))
				.addOrder(Order.asc("id"));
		List<Student> result = criteria.list();

		session.getTransaction().commit();
		return result;
	}
}
