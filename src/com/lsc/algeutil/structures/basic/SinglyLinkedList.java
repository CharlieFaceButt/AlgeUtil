package com.lsc.algeutil.structures.basic;

import com.lsc.algeutil.structures.ListInterface;

/**
 * A singly-linked linear list
 * @author charlieliu
 *
 */
public class SinglyLinkedList<T> implements ListInterface<T>{

	private SinglyLinkedNode<T> head = null;

	public SinglyLinkedList() {
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
		SinglyLinkedNode<T> node = head;
		while(node != null && !key.equals(node.getKey())){
			node = node.next;
		}
		if(node == null) return false;
		return true;
	}


	@Override
	public void Insert(T o) {
		// TODO Auto-generated method stub
		SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(o, head);
		head = node;
	}


	@Override
	public void Delete(T key) {
		// TODO Auto-generated method stub
		SinglyLinkedNode<T> prev = null;
		SinglyLinkedNode<T> node = head;
		while(node != null && !key.equals(node.getKey())){
			prev = node;
			node = node.next;
		}
		if(node == null) return;
		if(prev != null) prev.next = node.next;
		else if(node.next != null) head = node.next;
		else head = null;
	}


	@Override
	public int Length() {
		// TODO Auto-generated method stub
		SinglyLinkedNode<T> node = head;
		int i = 0;
		while(node != null){
			node = node.next;
			i ++;
		}
		return i;
	}
}
