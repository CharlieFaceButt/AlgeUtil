package com.lsc.algeutil.structures.basic;

public class SinglyLinkedNode<T> {
	private T data;
	public SinglyLinkedNode<T> next;
	
	public SinglyLinkedNode(T data, SinglyLinkedNode<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public T getKey(){
		return data;
	}
}
