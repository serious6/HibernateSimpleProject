package de.hawhamburg.hibernate.dao;

import java.io.Serializable;

/**
 * The Interface IGenericDao.
 * 
 * @param <T>
 *            the generic type
 */
public interface IGenericDao<T extends Serializable> {

	/**
	 * Adds the.
	 * 
	 * @param objectToBeAdded
	 *            the object
	 */
	public void add(T objectToBeAdded);

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the t
	 */
	public T findById(long id);

	/**
	 * Removes the.
	 * 
	 * @param objectToBeRemoved
	 *            the the object
	 */
	public void remove(T objectToBeRemoved);

	/**
	 * Update.
	 * 
	 * @param objectToBeUpdated
	 *            the object to be updated
	 * @return the t
	 */
	public T update(T objectToBeUpdated);
}
