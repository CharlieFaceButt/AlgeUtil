package com.lsc.algeutil.structures.basic;

import com.lsc.algeutil.structures.KeyTaggedDataParents;

public class SinglyLinkedNode<T> extends KeyTaggedDataParents<T,T>{
	private T data;
	public SinglyLinkedNode<T> next;
	
	public SinglyLinkedNode(T data, SinglyLinkedNode<T> next) {
		super();
		this.data = data;
		this.next = next;
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
