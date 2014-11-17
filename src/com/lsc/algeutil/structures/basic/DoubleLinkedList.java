package com.lsc.algeutil.structures.basic;

import com.lsc.algeutil.structures.ListInterface;

public class DoubleLinkedList<T> implements ListInterface<T>{

	DoubleLinkedNode<T> head = null;

	public DoubleLinkedList() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String output = super.toString();
		if(head != null) output += ("\n - template:" + head.getKey().getClass());
		output += ("\n - amount:" + Length());
		return output;
	}

	@Override
	public boolean Search(T key) {
		// TODO Auto-generated method stub
		DoubleLinkedNode<T> node = head;
		while(node != null && !key.equals(node.getKey())){
			node = node.next;
		}
		if(node == null) return false;
		return true;
	}

	@Override
	public void Insert(T o) {
		// TODO Auto-generated method stub
		DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(o, head, null);
		head.prev = node;
		head = node;
	}

	@Override
	public void Delete(T key) {
		// TODO Auto-generated method stub
		DoubleLinkedNode<T> node = head;
		while(node != null && !key.equals(node.getKey())){
			node = node.next;
		}
		if(node == null) return;
		
		if(node.prev != null){
			node.prev.next = node.next;
		}
		else if(node.next != null) head = node.next;
		else head = null;
		
		if(node.next != null) node.next.prev = node.prev;
	}

	@Override
	public int Length() {
		// TODO Auto-generated method stub
		DoubleLinkedNode<T> node = head;
		int i = 0;
		while(node != null){
			node = node.next;
			i ++;
		}
		return i;
	}
}
