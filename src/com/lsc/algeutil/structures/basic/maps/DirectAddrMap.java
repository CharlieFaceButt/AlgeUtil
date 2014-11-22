package com.lsc.algeutil.structures.basic.maps;


/**
 * A map of elements that are listed by their key values which are directly
 * mapped to the index of the storing list. The key values of those data are
 * java.lang.Integer and must has no collision with other keys, otherwise
 * data may lost during insert.
 * @author charlieliu
 *
 */
public class DirectAddrMap<D> extends MapObject<Integer, D>{

	/**
	 * the max and default range of the index
	 */
	private static int MAX_RANGE = 1024;
	
	/**
	 * real storage of elements
	 */
	private Object[] list = null;
	
	
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
		re += ("\n - length: " + GetCount() + "/" + list.length);
		return re;
	}

	@Override
	public boolean SearchByKey(Integer key) {
		// TODO Auto-generated method stub
		if(!isInRange(key)) return false;
		else if(list[key] != null) return true;
		return false;
	}
	
	@Override
	public D Insert(Integer k, D data) {
		// TODO Auto-generated method stub
		if(mapping == null){
			System.out.println("DirectAddrMap: insert failure because no mapping" +
					" has been defined");
			return null;
		}
		int key = 0;
		if(k == null) key = mapping.generateKey(data);
		else key = k;
		
		if(!isInRange(key)){
			System.out.println("DirectAddrMap: insert failed because the key is out of range");
			return null;
		}
		
		@SuppressWarnings("unchecked")
		D result = (D)list[key];
		list[key] = data;
		return result;
	}

	@Override
	public D Delete(Integer key) {
		// TODO Auto-generated method stub
		D re = null;
		if(isInRange(key) && list[key] != null){
			re = (D)list[key];
			list[key] = null;
		}
		return re;
	}

	/**
	 * Only when the key can be generated by data can this function be called 
	 * @param data
	 * @throws Exception when mapping is not defined to generate key
	 */
	public void DeleteByData(D data) throws Exception {
		// TODO Auto-generated method stub
		if(mapping == null) throw new Exception("DirectAddrMap: delete failure" +
				" because mapping function for generating keys is not defined");
		int key = mapping.generateKey(data);
		if(isInRange(key) && list[key] != null) list[key] = null;
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		int len = 0;
		for(int i=0 ; i<list.length ; i++){
			if(list[i] != null) len ++;
		}
		return len;
	}
	
}
