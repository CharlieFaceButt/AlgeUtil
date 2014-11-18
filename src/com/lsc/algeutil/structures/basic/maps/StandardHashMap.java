package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.MapInterface;

public class StandardHashMap<K,D> implements MapInterface<K, D>{

	@Override
	public boolean SearchByData(D data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SearchByKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Insert(K key, D data) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Delete(K key) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int Length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public K computeKey(D data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public D getData(K key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int hash(K key){
		return 0;
	}

}
