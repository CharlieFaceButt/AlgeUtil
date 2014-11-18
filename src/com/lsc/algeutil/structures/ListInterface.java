package com.lsc.algeutil.structures;

/**
 * List provide such basic operations for a list of data as:
 *  search,insert,delete,length
 * @author charlieliu
 *
 * @param <T>
 */
public interface ListInterface<T> {

	/**
	 * search the element that has the same key value
	 * @param key
	 * @return true if list contains the element;
	 * 	false if no such element is found
	 */
	abstract public boolean Search(T key);
	
	/**
	 * insert an element to the list
	 * @param o the data to insert
	 * @throws Exception if data can not be inserted probably bacause the data 
	 * are not perfected follows the principle of the container
	 */
	abstract public void Insert(T o);
	
	/**
	 * delete an element in the list by its key
	 * @param key
	 */
	abstract public void Delete(T key);
	
	/**
	 * Count the amount of the stored elements 
	 * @return
	 */
	abstract public int Length();
	
}
