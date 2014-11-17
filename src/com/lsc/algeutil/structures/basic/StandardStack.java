package com.lsc.algeutil.structures.basic;

/**
 * Stack reserves a list of elements that subject to the FILO principle
 * @author charlieliu
 *
 */
public class StandardStack {

	/**
	 * The list of elements
	 */
	private Object[] stack = null;
	
	/**
	 * Track of the top of the stack
	 */
	private int top = 0;

	/**
	 * Construct a standard stack will open a space for storing the stack
	 * @param max the length of the space
	 */
	public StandardStack(int max) {
		super();
		stack = new Object[max];
	}
	
	/**
	 * @return true if the stack has no elements stored or all elements 
	 * popped out 
	 */
	public boolean isEmpty(){
		if(top == 0) return true;
		else return false;
	}
	
	/**
	 * Add a element to the top of the stack
	 * @param o java.Object
	 * @return the position of the newly pushed element;
	 *  -1 if there is no space in the stack for more elements;
	 * 	
	 */
	public int push(Object o){
		if(top >= (stack.length - 1)) return -1;
		top ++;
		stack[top] = o;
		return top;
	}
	
	/**
	 * Pop the elements on the top of the stack
	 * @return the popped elements as java.Object
	 * @throws Exception when the stack is empty
	 */
	public Object pop() throws Exception{
		if(isEmpty())
			throw new Exception("StandardStack:you are poping an empty stack");
		else{
			top --;
			return stack[top+1];
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String r = super.toString();
		r += ("\n- " + top +"/" + stack.length + " elements");
		if(top > 0) 
			r += ("\n- top element:" + stack[top].toString());
		return r;
	}
}
