package com.lsc.algeutil.structures.basic;

import com.lsc.algeutil.structures.KeyTaggedDataParents;

public class DoubleLinkedNode<T> extends KeyTaggedDataParents<T,T>{
	
	private T data;
	public DoubleLinkedNode<T> next;
	public DoubleLinkedNode<T> prev;
	public DoubleLinkedNode(T data, DoubleLinkedNode<T> next,
			DoubleLinkedNode<T> prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	@Override
	public T getKey() {
		// TODO Auto-generated method stub
		return data;
	}
	@Override
	public T generateKey(T data) {
		// TODO Auto-generated method stub
		return data;
	}
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
