package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.HashingInterface;

/**
 * -_-unfinished
 * @author charlieliu
 *
 * @param <D>
 */
public class PerfectHashMap<D> extends MapObject<Integer, D> {

	private StandardHashMap<Integer, D>[] list = null;
	
	private HashingInterface<Integer> hashFunc = null;
	
	private Domain domain = null;
	
	@Override
	public boolean SearchByKey(Integer key) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public D Insert(Integer key, D data) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public D Delete(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer computeKey(D data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public D getData(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

}
