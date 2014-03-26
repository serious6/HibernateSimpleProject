package de.hawhamburg.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;

import de.hawhamburg.hibernate.utils.SessionFactoryBuilder;

public class GenericDao<T extends Serializable> implements IGenericDao<T> {

	private final Class<T> typeParameterClass;

	public GenericDao(Class<T> typeParameterClass) {
		super();
		assert typeParameterClass != null;

		this.typeParameterClass = typeParameterClass;
	}

	@Override
	public void add(T theObject) {
		Session session = null;
		try {
			assert theObject != null;

			session = getTransaction();
			session.save(theObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(long id) {
		assert id > 0;

		Session session = null;
		try {

			session = getTransaction();
			Object result = session.get(typeParameterClass, id);
			session.getTransaction().commit();
			return (result != null ? (T) result : null);
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void remove(T theObject) {
		assert theObject != null;

		Session session = null;
		try {

			session = getTransaction();
			session.delete(theObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public T update(T objectToBeUpdated) {
		assert objectToBeUpdated != null;

		Session session = null;
		try {

			session = getTransaction();
			session.merge(objectToBeUpdated);

			session.getTransaction().commit();
			return objectToBeUpdated;
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Gets the Session and begins a Transaction.
	 * 
	 * @return the transaction
	 */
	protected Session getTransaction() {
		Session session = SessionFactoryBuilder.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session;
	}

}
