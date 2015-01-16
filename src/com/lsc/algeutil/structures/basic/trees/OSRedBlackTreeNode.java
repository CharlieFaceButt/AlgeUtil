package com.lsc.algeutil.structures.basic.trees;

public class OSRedBlackTreeNode<D> extends RedBlackTreeNode<D> {

	private int tSize = 0;

	public OSRedBlackTreeNode(int color, Integer key, D data,
			BinaryTreeNode<D> left, BinaryTreeNode<D> right,
			BinaryTreeNode<D> parent) {
		super(color, key, data, left, right, parent);
		countSize();
	}
	
	public int getTreeSize(){
		return tSize;
	}
	
	public void countSize(){
		tSize = 1 + ((OSRedBlackTreeNode<D>)left).getTreeSize() +
				((OSRedBlackTreeNode<D>)right).getTreeSize();
	}
	
	@Override
	public void LeftRotate() {
		// TODO Auto-generated method stub
		if(right == null) return;
		
		OSRedBlackTreeNode<D> rightNode = (OSRedBlackTreeNode<D>)(this.right);
		
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
		
		/*reset the size*/
		this.countSize();
		rightNode.countSize();
		rightNode = (OSRedBlackTreeNode<D>)(rightNode.parent);
		if(rightNode != null) rightNode.countSize();
	}
	
	@Override
	public void RightRotate() {
		// TODO Auto-generated method stub
		if(left == null) return;
		
		OSRedBlackTreeNode<D> leftNode = (OSRedBlackTreeNode<D>)(this.left);
		
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
		
		/*reset the size*/
		this.countSize();
		leftNode.countSize();
		leftNode = (OSRedBlackTreeNode<D>)(leftNode.parent);
		if(leftNode != null) leftNode.countSize();
	}
}
