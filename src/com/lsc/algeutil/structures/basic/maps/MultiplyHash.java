package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.HashingInterface;

public class MultiplyHash<K> implements HashingInterface<K> {
	
	@Override
	public int doHash(K key,int slotMax) {
		// TODO Auto-generated method stub
		/*convert K to integer*/
		int k = key.hashCode();
		
		/*Recommended result 
		 * demonstration for this algorithm see Chapter 11 in book Introduction 
		 * of Algorithm*/
		double kk = k * (Math.sqrt(5) - 1) / 2;
		return (int)(slotMax * (kk - Math.floor(kk)));
	}
}
