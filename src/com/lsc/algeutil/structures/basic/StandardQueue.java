package com.lsc.algeutil.structures.basic;

/**
 * A queue conserves a list of elements that subjects to FIFO principle
 * @author charlieliu
 *
 */
public class StandardQueue {

	/**
	 * the queue that stores the elements
	 */
	private Object[] queue = null;
	
	/**
	 * head of the queue
	 */
	private int head = 0;
	
	/**
	 * tail of the queue
	 */
	private int tail = 0;
	
	/**
	 * when head=tail, this attribute helps distinguish whether the queue is empty or full
	 */
	private boolean isEmpty = true;

	public StandardQueue(int max) {
		super();
		queue = new Object[max];
	}
	
	/**
	 * add element to the tail of the queue
	 * @param o java.Object
	 * @return the position where the object is added;
	 *  -1 if the queue is full
	 */
	public int EnQueue(Object o){
		if(!isEmpty && head == tail) return -1;
		queue[tail] = o;
		if(tail == queue.length) tail = 0;
		else tail ++;
		isEmpty = false;
		return tail;
	}
	
	/**
	 * remove the element at the head of the queue
	 * @return the element object as java.Object
	 * @throws Exception when the queue is empty
	 */
	public Object DeQueue() throws Exception{
		if(isEmpty) throw new Exception("StandardQueue: can not dequeue when queue is empty");
		Object re = queue[head];
		if(head == queue.length) head = 0;
		else head ++;
		if(head == tail) isEmpty = true;
		return re;
	}
	
}
