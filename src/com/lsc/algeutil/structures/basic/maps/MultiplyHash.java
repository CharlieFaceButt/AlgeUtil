package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.HashingInterface;

/**
 * This implements the hashing interface that do the hashing for hash maps,<br>
 * using a method of multiple plus mod of key
 * Details see Chapter 12 in book Introduction of Algorithm
 * @author charlieliu
 *
 * @param <K>
 */
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
