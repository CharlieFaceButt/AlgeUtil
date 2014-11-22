package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.HashingInterface;

/**
 * This implement the hashing of a hash map, using full domain method<br>
 * Details see Chapter 11 in book Introduction of Algorithm 
 * @author charlieliu
 *
 * @param <K> the Key
 */
public class FullDomainHash<K> implements HashingInterface<K> {

	/**
	 * prime number that is bigger than domain
	 */
	private long p = 131;
	
	/**
	 * randomly chosen from 0...p-1
	 */
	private long a = 0;
	
	/**
	 * randomly chosen from 1...p-1
	 */
	private long b = 0;
	
	public FullDomainHash(){
		super();
		generateP(p);
	}
	public FullDomainHash(long domain) {
		super();
		this.p = generateP(domain);
	}
	
	/**
	 * generate p,a and b for the algorithm
	 * This function can be explicitly called
	 * @param domain
	 * @return p
	 */
	public long generateP(long domain){

		//UNFINISHED:generate p as the smallest prime number that is larger
		//than domain
		p = domain + 3;
		
		a = (long)((p - 1) * Math.random());
		b = (long)((p - 2) * Math.random() + 1);
		
		return p;
	}

	@Override
	public int doHash(K key, int m) {
		// TODO Auto-generated method stub
		/*convert K to integer*/
		int k = key.hashCode();
		/*Recommended result 
		 * demonstration for this algorithm see Chapter 11 in book Introduction 
		 * of Algorithm*/
		long kk = (long)a * k + (long)b;
		return (int)((kk % p) % m);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = super.toString();
		result += "\n\t - p = " + p + "; a = " + a + "; b = " + b;
		return result;
	}
}
