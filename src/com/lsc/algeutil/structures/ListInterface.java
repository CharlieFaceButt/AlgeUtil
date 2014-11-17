package com.lsc.algeutil.structures;

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
	 * @param o
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
