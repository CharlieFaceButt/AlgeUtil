package com.lsc.algeutil.structures;

/**
 * This makes the mapping can be customized disparately from the map class
 * default mapping. 
 * @author charlieliu
 *
 * @param <K>
 */
public abstract class KeyTaggedDataParents<K,D> {
	
	public abstract K getKey();
	
	public abstract K generateKey(D data);
	
	public abstract D getData();
}
