package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.HashingInterface;

public class FullDomainHash<K> implements HashingInterface<K> {

	/**
	 * prime number that is bigger than domain
	 */
	private long p = 131;
	
	public FullDomainHash(){
		super();
	}
	public FullDomainHash(int domain) {
		super();
		this.p = domain;
	}

	@Override
	public int doHash(K key, int slotMax) {
		// TODO Auto-generated method stub
		/*convert K to integer*/
		int k = key.hashCode();
		
		/*Recommended result 
		 * demonstration for this algorithm see Chapter 11 in book Introduction 
		 * of Algorithm*/
		long kk = (long)((p - 1) * Math.random()) * k + (long)((p - 2) * Math.random() + 1);
		return (int)((kk % p) % slotMax);
	}

}
