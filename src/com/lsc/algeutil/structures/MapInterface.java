package com.lsc.algeutil.structures;

/**
 * Map basically contains the rules of mapping the data with keys, this 
 * interface stipulate two standard function of map: getData,computeKey
 * @author charlieliu
 *
 * @param <K>
 * @param <D>
 */
public interface MapInterface<K, D> {
	
	/**
	 * search the element that match the data, will call SearchByKey finally.
	 * @param key
	 * @return true if list contains the element;
	 * 	false if no such element is found
	 */
	abstract public boolean SearchByData(D data);
	
	/**
	 * search the element that has the same key value
	 * @param key
	 * @return true if list contains the element;
	 * 	false if no such element is found
	 */
	abstract public boolean SearchByKey(K key);
	
	/**
	 * insert an element to the list
	 * @param o the data to insert
	 * @throws Exception if data can not be inserted probably because the data 
	 * are not perfected follows the principle of the container
	 */
	abstract public void Insert(K key, D data);
	
	/**
	 * delete an element in the list by its key
	 * @param key
	 */
	abstract public void Delete(K key);
	
	/**
	 * Count the amount of the stored elements 
	 * @return
	 */
	abstract public int Length();
	
	/**
	 * compute key for a given data regardless of whether it is in a map
	 * @param data
	 * @return the possible key value of the data;
	 * 	-1 if the mapping is not defined or data can not be mapped
	 */
	abstract K computeKey(D data);
	
	/**
	 * get the data that a key mapped
	 * @param key
	 * @return the data 
	 */
	abstract D getData(K key);
}
