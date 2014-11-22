package com.lsc.algeutil.structures.basic.trees;

/**
 * Node of RedBlackTree
 * every node has an attribute named color with values either be RED or BLACK
 * @author charlieliu
 *
 * @param <D> the data type
 */
public class RedBlackTreeNode<D> extends BinaryTreeNode<D> {

	public static final int BLACK = 0;
	public static final int RED = 1;
	
	private int color = RED;
	
	public RedBlackTreeNode(int color, Integer key, D data, BinaryTreeNode<D> left,
			BinaryTreeNode<D> right, BinaryTreeNode<D> parent) {
		super(key, data, left, right, parent);
		// TODO Auto-generated constructor stub
		this.setColor(color);
	}

	public void LeftRotate(){
		if(right == null) return;
		
		BinaryTreeNode<D> rightNode = this.right;
		
		/*links between rightNode and this*/
		rightNode.parent = this.parent;
		this.right = rightNode.left;
		
		/*links between this and parent*/
		if(this.parent != null){
			if(this.parent.left == this) this.parent.left = rightNode;
			else this.parent.right = rightNode;
		}
		this.parent = rightNode;
		
		/*links between rightNode.left and rightNode*/
		if(rightNode.left != null) rightNode.left.parent = this;
		rightNode.left = this;
	}
	
	public void RightRotate(){
		if(left == null) return;
		
		BinaryTreeNode<D> leftNode = this.left;
		
		/*links between leftNode and this*/
		leftNode.parent = this.parent;
		this.left = leftNode.right;
		
		/*links between this and parent*/
		if(this.parent != null){
			if(this.parent.left == this) this.parent.left = leftNode;
			else this.parent.right = leftNode;
		}
		this.parent = leftNode;
		
		/*links between leftNode.right and leftNode*/
		if(leftNode.right != null) leftNode.left.parent = this;
		leftNode.right = this;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	public String OrderedTreeWalk() {
		// TODO Auto-generated method stub
		String result = "";
		if(this.left != null) result += (this.key + "left child:" + left.OrderedTreeWalk());
		result += ("(key:" + this.key + ",color" + this.color + ");");
		if(this.right != null) result += (this.key + "child of " + right.OrderedTreeWalk());
		return result;
	}
}
