package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.KeyTaggedDataParents;
import com.lsc.algeutil.structures.MapInterface;

/**
 * A map of elements that are listed by their key values which are directly
 * mapped to the index of the storing list. The key values of those data are
 * java.lang.Integer and data must has no collision with other data, otherwise
 * data may lost during insert.
 * @author charlieliu
 *
 */
public class DirectAddrMap<D> implements MapInterface<Integer, D>{

	/**
	 * the max and default range of the index
	 */
	private static int MAX_RANGE = 1024;
	
	/**
	 * real storage of elements
	 */
	private Object[] list = null;
	
	private KeyTaggedDataParents<Integer,D> mapping = null;
	
	public DirectAddrMap(int rangeOfKey){
		super();
		if(rangeOfKey < 0 || rangeOfKey > MAX_RANGE){
			System.out.println("DirectAddrMap: can not create this map when range is not between 0 and " + MAX_RANGE);
			list = new Object[MAX_RANGE];
		}
		else list = new Object[rangeOfKey];
	}
	
	/**
	 * whether a given key value avail to map the list which means whether it is between 0 and the length of the list
	 * @param key
	 * @return true if the key can map to the list;
	 */
	private boolean isInRange(int key){
		return key >= 0 || key < list.length;
	}


	@Override
	public Integer computeKey(D data) {
		// TODO Auto-generated method stub
		if(mapping == null) return -1; 
		else return mapping.generateKey(data);
	}


	@SuppressWarnings("unchecked")
	@Override
	public D getData(Integer key) {
		// TODO Auto-generated method stub
		if(!isInRange(key)) return null;
		else return (D)list[key];
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String re = super.toString();
		re += ("\n - length: " + Length() + "/" + list.length);
		return re;
	}

	@Override
	public boolean SearchByData(D data) {
		// TODO Auto-generated method stub
		int key = -1;
		if(mapping == null){}
		else key = mapping.generateKey(data);
		return SearchByKey(key);
	}

	@Override
	public boolean SearchByKey(Integer key) {
		// TODO Auto-generated method stub
		if(!isInRange(key)) return false;
		else if(list[key] != null) return true;
		return false;
	}
	
	public void Insert(KeyTaggedDataParents<Integer,D> item){
		if(mapping == null) mapping = item; 
		Insert(item.getKey(),item.getData());
	}
	
	@Override
	public void Insert(Integer k, D data) {
		// TODO Auto-generated method stub
		if(mapping == null){
			System.out.println("DirectAddrMap: insert failure because no mapping" +
					" has been defined");
			return;
		}
		int key = 0;
		if(k == null) key = mapping.generateKey(data);
		else key = k;
		
		if(!isInRange(key)){
			System.out.println("DirectAddrMap: insert failed because the key is out of range");
		}
		else list[key] = data;
	}

	@Override
	public void Delete(Integer key) {
		// TODO Auto-generated method stub
		if(isInRange(key) && list[key] != null) list[key] = null;
	}

	public void DeleteByData(D data) {
		// TODO Auto-generated method stub
		int key = mapping.generateKey(data);
		if(isInRange(key) && list[key] != null) list[key] = null;
	}

	@Override
	public int Length() {
		// TODO Auto-generated method stub
		int len = 0;
		for(int i=0 ; i<list.length ; i++){
			if(list[i] != null) len ++;
		}
		return len;
	}

	
}
