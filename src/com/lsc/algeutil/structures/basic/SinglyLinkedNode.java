package com.lsc.algeutil.structures.basic;


public class SinglyLinkedNode<T> extends KeyTaggedDataBean<T,T>{
	
	public SinglyLinkedNode<T> next;
	
	public SinglyLinkedNode(T data, SinglyLinkedNode<T> next) {
		super(data,data);
		this.data = data;
		this.next = next;
	}

	@Override
	public T generateKey(T data) {
		// TODO Auto-generated method stub
		return data;
	}
}
