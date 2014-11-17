package com.lsc.algeutil.structures.basic;

public class DoubleLinkedNode<T>{
	
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

	public T getKey(){
		return data;
	}
}
