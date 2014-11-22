package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.basic.KeyTaggedDataBean;

/**
 * Map basically contains the rules of mapping the data with keys, this 
 * interface stipulate two standard function of map: getData,computeKey
 * @author charlieliu
 *
 * @param <K>
 * @param <D>
 */
public abstract class MapObject<K, D> {

	protected KeyTaggedDataBean<K,D> mapping = null;
	
	/**
	 * search the element that match the data, will call SearchByKey finally.
	 * @param key
	 * @return true if list contains the element;
	 * 	false if no such element is found or mapping function is not defined
	 */
	public boolean SearchByData(D data){
		if(mapping == null){
			System.out.println(this.getClass().toString() + "search stopped because mapping function is not defined");
			return false;
		}

		K key = mapping.generateKey(data);
		return SearchByKey(key);
	}
	
	/**
	 * search the element that has the same key value
	 * @param key
	 * @return true if list contains the element;
	 * 	false if no such element is found
	 */
	public abstract boolean SearchByKey(K key);

	/**
	 * insert the key-value pair to the list as a whole, will finally call 
	 * Insert(K,D)
	 * @param item
	 */
	public void Insert(KeyTaggedDataBean<K,D> item){
		if(mapping == null) setMapping(item); 
		Insert(item.getKey(),item.getData());
	}
	
	/**
	 * insert an element with key to the list
	 * @param o the data to insert
	 * @throws Exception if data can not be inserted probably because the data 
	 * are not perfected follows the principle of the container
	 */
	abstract public D Insert(K key, D data);
	
	
	/**
	 * delete an element in the list by its key
	 * @param key
	 * @return the original value that has the same key
	 */
	abstract public D Delete(K key);
	
	/**
	 * Count the amount of the stored elements 
	 * @return
	 */
	abstract public int GetCount();
	
	/**
	 * compute key for a given data regardless of whether it is in a map
	 * @param data
	 * @return the possible key value of the data;
	 * 	-1 if the mapping is not defined or data can not be mapped
	 */
	public abstract K computeKey(D data);
	
	/**
	 * get the data that a key mapped
	 * @param key
	 * @return the data 
	 */
	public abstract D getData(K key);
	
	/**
	 * Explicitly set the mapping
	 * @param map
	 */
	public void setMapping(KeyTaggedDataBean<K, D> map){
		mapping = map;
	}
}
