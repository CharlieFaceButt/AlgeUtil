package com.lsc.algeutil.structures;

public interface HashingInterface<K> {

	/**
	 * The hashing method for HashMap, transfer a key to an index
	 * @param key
	 * @return the index wanted; -1 if the key is null
	 */
	abstract public int doHash(K key, int slotMax);
}
