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
		try {
			assert theObject != null;

			Session session = getTransaction();
			session.save(theObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(long id) {
		try {
			assert id > 0;

			Session session = getTransaction();
			Object result = session.get(typeParameterClass, id);
			session.getTransaction().commit();
			return (result != null ? (T) result : null);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void remove(T theObject) {
		try {
			assert theObject != null;

			Session session = getTransaction();
			session.delete(theObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Gets the Session and begins a Transaction.
	 * 
	 * @return the transaction
	 */
	private Session getTransaction() {
		Session session = SessionFactoryBuilder.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session;
	}
}
