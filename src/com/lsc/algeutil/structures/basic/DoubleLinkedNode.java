package com.lsc.algeutil.structures.basic;


public class DoubleLinkedNode<T> extends KeyTaggedDataBean<T,T>{
	
	public DoubleLinkedNode<T> next;
	public DoubleLinkedNode<T> prev;
	public DoubleLinkedNode(T data, DoubleLinkedNode<T> next,
			DoubleLinkedNode<T> prev) {
		super(data,data);
		this.next = next;
		this.prev = prev;
	}
	
	@Override
	public T generateKey(T data) {
		// TODO Auto-generated method stub
		return data;
	}

}
