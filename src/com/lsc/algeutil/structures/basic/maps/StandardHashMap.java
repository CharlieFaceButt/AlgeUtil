package com.lsc.algeutil.structures.basic.maps;

import com.lsc.algeutil.structures.HashingInterface;
import com.lsc.algeutil.structures.basic.KeyTaggedDataBean;
import com.lsc.algeutil.structures.basic.SinglyLinkedNode;

/**
 * A standard hash map will use multiplyHash as default hashing method, <br>
 * but hashing method can be replaced by using other implementations of <br>
 * hashingInterface.
 * Further more it is still extends MapObject so that it can define how <br>
 * generate a key according to the data, method can be customized by <br>
 * implementing 
 * @author charlieliu
 *
 * @param <K> the key type
 * @param <D> the data type
 */
public class StandardHashMap<K,D> extends MapObject<K, D>{

	public static int MAX_SLOT_NUM = 1024;
	
	private Object[] list = null;
	
	private HashingInterface<K> hashFunc = null;
	
	private int threshold = MAX_SLOT_NUM;
	
	public void init(HashingInterface<K> hashFunc) {
		list = new Object[threshold];
		
		if(hashFunc != null) this.hashFunc = hashFunc;
		/*set default hashing when hashFunc is null*/
		else this.hashFunc = new MultiplyHash<K>();
	}
	
	public StandardHashMap(HashingInterface<K> hashFunc) {
		super();
		init(hashFunc);
	}
	public StandardHashMap(){
		super();
		init(null);
	}
	public StandardHashMap(int slotMax) {
		super();
		this.threshold = slotMax;
		init(null);
	}

	@Override
	public boolean SearchByKey(K key) {
		// TODO Auto-generated method stub
		int index = hashFunc.doHash(key,threshold);
		
		/*get the head of the chain*/
		@SuppressWarnings("unchecked")
		SinglyLinkedNode<KeyTaggedDataBean<K, D>> entry 
			= (SinglyLinkedNode<KeyTaggedDataBean<K, D>>)(list[index]);
		
		/*loop to find the data that has the same key value*/
		while(entry != null){
			if(entry.getData().getKey().equals(key)) return true;
			entry = entry.next;
		}
		
		return false;
	}

	@Override
	public D Insert(K key, D data) {
		// TODO Auto-generated method stub
		int index = hashFunc.doHash(key,threshold);
		
		/*get the head of the chain*/
		@SuppressWarnings("unchecked")
		SinglyLinkedNode<KeyTaggedDataBean<K, D>> entry 
			= (SinglyLinkedNode<KeyTaggedDataBean<K, D>>)(list[index]);
		
		/*to get the old value if there is one*/
		D oldValue = null;
		
		/*search in a list to find a bean that has the same key value, 
		replace it if there is one*/
		SinglyLinkedNode<KeyTaggedDataBean<K, D>> temp = entry;
		while(temp != null){
			if(temp.getData().getKey().equals(key)){
				oldValue = temp.getData().getData();
				temp.getData().setData(data);
				return oldValue;
			} 
			temp = temp.next;
		}
		
		/*if no bean is found has the same key value, add this data to the list*/
		list[index] = new SinglyLinkedNode<KeyTaggedDataBean<K,D>>(
				new KeyTaggedDataBean<K, D>(key, data)
				, entry);
		dataCount ++;
		return null;
		
	}
	
	@Override
	public D Delete(K key) {
		// TODO Auto-generated method stub
		int index = hashFunc.doHash(key,threshold);
		
		/*get the head of the chain*/
		@SuppressWarnings("unchecked")
		SinglyLinkedNode<KeyTaggedDataBean<K, D>> entry 
			= (SinglyLinkedNode<KeyTaggedDataBean<K, D>>)(list[index]);
		
		/*track the previous node of the entry*/
		SinglyLinkedNode<KeyTaggedDataBean<K, D>> prev = null;
		
		/*loop to find the one that has the targeted key value
		 * then remove the data node and return the old value if there is one*/
		while(entry != null){
			if(entry.getData().getKey().equals(key)){
				if(prev != null) prev.next = entry.next;
				else list[index] = entry.next;
				dataCount --;
				return entry.getData().getData();
			}
			prev = entry;
			entry = entry.next;
		}
		
		/*when no such data is found, do nothing*/
		return null;
	}
	
	private int dataCount = 0;
	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		return dataCount;
	}

	@Override
	public K computeKey(D data) {
		// TODO Auto-generated method stub
		KeyTaggedDataBean<K, D> bean = new KeyTaggedDataBean<K, D>(null, data);
		return bean.generateKey(data);
	}

	@Override
	public D getData(K key) {
		// TODO Auto-generated method stub
		int index = hashFunc.doHash(key,threshold);
		
		/*get the head of the chain*/
		@SuppressWarnings("unchecked")
		SinglyLinkedNode<KeyTaggedDataBean<K, D>> entry 
			= (SinglyLinkedNode<KeyTaggedDataBean<K, D>>)(list[index]);
		
		while(entry != null){
			if(entry.getData().getKey().equals(key))
				return entry.getData().getData();
		}

		return null;
	}

	/**
	 * Get the number of slots that have stored data
	 * @return
	 */
	public int getOccupiedSlotNum(){
		int re = 0;
		for(int i=0 ; i<list.length ; i++){
			if(list[i] != null) re ++; 
		}
		return re;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = super.toString();
		result += "\n - hashing method:" + hashFunc.toString();
		result += "\n - " + GetCount() + "data stored";
		result += "\n - " + getOccupiedSlotNum() + "/" + list.length + "slots occupied";
		return result;
	}
}
