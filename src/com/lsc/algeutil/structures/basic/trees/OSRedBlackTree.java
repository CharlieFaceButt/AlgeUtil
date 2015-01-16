package com.lsc.algeutil.structures.basic.trees;

public class OSRedBlackTree<D> extends RedBlackTree<D> {

	public D Insert(Integer key, D data) {
		/*parent of insert node*/
		OSRedBlackTreeNode<D> parentNode = null;
		/*node that check the key value*/
		OSRedBlackTreeNode<D> node = (OSRedBlackTreeNode<D>)root;
		/*locate the insert position*/
		while(node != null){
			parentNode = node;
			if(key < node.getKey()) node = (OSRedBlackTreeNode<D>)(node.left);
			else if(key > node.getKey()) node = (OSRedBlackTreeNode<D>)(node.right);
			else{
				D oldData = node.getData();
				node.setData(data);
				return oldData;
			}
		}
		
		/*create node*/
		OSRedBlackTreeNode<D> insert = new OSRedBlackTreeNode<D>(
				1, key, data, null, null, parentNode);
		/*if root not initiated*/
		if(parentNode == null) root = insert;
		/*insert node*/
		else if(key < parentNode.getKey()) parentNode.left = insert;
		else parentNode.right = insert;
		
		/*fix up the tree from the insert node to the top*/
		RBInsertFixUp(insert);
		return null;
	};
	@Override
	protected void RBInsertFixUp( RedBlackTreeNode<D> insert) {
		// TODO Auto-generated method stub
		/*parent node*/
		OSRedBlackTreeNode<D> p = (OSRedBlackTreeNode<D>)(insert.parent);
		/*uncle node that has the same parent of insert's parent*/
		OSRedBlackTreeNode<D> uncle = null;
		
		/*When the parent is BLACK, the work is done */
		while(p !=null && p.getColor() == OSRedBlackTreeNode.RED){
			/*parent is the left child of grandparent*/
			if(p == p.parent.left){
				
				uncle = (OSRedBlackTreeNode<D>)(p.parent.right);
				
				/*parent and uncle are both RED, set them BLACK and set grandparent RED*/
				if(uncle != null && uncle.getColor() == OSRedBlackTreeNode.RED){
					p.setColor(OSRedBlackTreeNode.BLACK);
					uncle.setColor(OSRedBlackTreeNode.BLACK);
					insert = ((OSRedBlackTreeNode<D>)(p.parent));
					insert.setColor(OSRedBlackTreeNode.RED);
				}
				/*When uncle is BLACK and parent is RED, parent set BLACK and grand parent
				 * set RED, then right rotate from grandparent*/
				else{
					if(insert == p.right){
					insert = p;
					insert.LeftRotate();
					}
					p = (OSRedBlackTreeNode<D>)(insert.parent);
					p.setColor(OSRedBlackTreeNode.BLACK);
					p = (OSRedBlackTreeNode<D>)(p.parent);
					p.setColor(OSRedBlackTreeNode.RED);
					p.RightRotate(); 
				}
			}
			/*same as the if clause, reverse the left and right*/
			else{
				uncle = (OSRedBlackTreeNode<D>)(p.parent.left);
				if(uncle != null && uncle.getColor() == OSRedBlackTreeNode.RED){
					p.setColor(OSRedBlackTreeNode.BLACK);
					uncle.setColor(OSRedBlackTreeNode.BLACK);
					insert = ((OSRedBlackTreeNode<D>)(p.parent));
					insert.setColor(OSRedBlackTreeNode.RED);
				}
				else{
					if(insert == p.left){
					insert = p;
					insert.RightRotate();
					}
					p = (OSRedBlackTreeNode<D>)(insert.parent);
					p.setColor(OSRedBlackTreeNode.BLACK);
					p = (OSRedBlackTreeNode<D>)(p.parent);
					p.setColor(OSRedBlackTreeNode.RED);
					p.LeftRotate(); 
				}
			}
			/*find parent parent*/
			p = (OSRedBlackTreeNode<D>)(insert.parent);
		}
		/*make sure the root is BLACK*/
		((OSRedBlackTreeNode<D>)root).setColor(OSRedBlackTreeNode.BLACK);
	}
	
	public D Delete(Integer key) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		
		/*the node you want to delete*/
		OSRedBlackTreeNode<D> node = (OSRedBlackTreeNode<D>)(root.Search(key));
		/*node not exist*/
		if(node == null) return null;
		
		/*help do the deletion*/
		OSRedBlackTreeNode<D> delete = null;
		/*distinguish whether node has two child, delete itself if it doesn't,
		 * otherwise replace itself with its successor and delete its successor*/
		if(node.left == null || node.right == null)
			delete = node;
		else delete = (OSRedBlackTreeNode<D>)(node.Successor());
		
		/*get the child of the delete node*/
		OSRedBlackTreeNode<D> child = null;
		if(delete.left != null) child = (OSRedBlackTreeNode<D>)(delete.left);
		else child = (OSRedBlackTreeNode<D>)(delete.right);
		
		/*deletion*/
		/*when doing the real deletion, link the node's parent and its child*/
		if(child != null) child.parent = delete.parent;
		/*when it is the root you want to delete*/
		if(delete.parent == null) root = child;
		else if(delete == delete.parent.left)
			delete.parent.left = child;
		else delete.parent.right = child;
		
		/*when node has two children, replace itself by its successor*/
		D oldData = null;
		if(delete != node){
			node.setKey(delete.getKey());
			oldData = node.getData();
			node.setData(delete.getData());
		}
		
		/*only if the deleted node is BLACK node that break the red-black principle*/
		if(delete.getColor() == OSRedBlackTreeNode.BLACK)
			RBDeleteFixUp(child);
		return oldData;
	}
	
	@Override
	protected void RBDeleteFixUp(RedBlackTreeNode<D> node) {
		// TODO Auto-generated method stub
		if(node == null) return;
		
		OSRedBlackTreeNode<D> p = null;
		OSRedBlackTreeNode<D> uncle = null;
		OSRedBlackTreeNode<D> uncleLeft = null;
		OSRedBlackTreeNode<D> uncleRight = null;
		
		while(node != root && node.getColor() != OSRedBlackTreeNode.BLACK){
			
			p = (OSRedBlackTreeNode<D>)(node.parent);
			
			/*if the node is its parent's left child*/
			if(node == p.left){
				uncle = (OSRedBlackTreeNode<D>)(p.right);
				if(uncle != null && uncle.getColor() == OSRedBlackTreeNode.RED){
					uncle.setColor(OSRedBlackTreeNode.BLACK);
					p.setColor(OSRedBlackTreeNode.RED);
					p.LeftRotate();
					p = (OSRedBlackTreeNode<D>)(node.parent);
					uncle = (OSRedBlackTreeNode<D>)(p.right);
				}
				uncleLeft = ((OSRedBlackTreeNode<D>)(uncle.left));
				uncleRight = ((OSRedBlackTreeNode<D>)(uncle.right));
				if(uncleLeft.getColor() == OSRedBlackTreeNode.BLACK 
						&& uncleRight.getColor() == OSRedBlackTreeNode.BLACK){
					uncle.setColor(OSRedBlackTreeNode.RED);
					node = p;
				}
				else if(uncleRight.getColor() == OSRedBlackTreeNode.BLACK){
					uncleLeft.setColor(OSRedBlackTreeNode.BLACK);
					uncle.setColor(OSRedBlackTreeNode.RED);
					uncle.RightRotate();
					uncle = (OSRedBlackTreeNode<D>)(p.right);
				}
				uncle.setColor(p.getColor());
				p.setColor(OSRedBlackTreeNode.BLACK);
				((OSRedBlackTreeNode<D>)(uncle.right)).setColor(OSRedBlackTreeNode.BLACK);
				p.LeftRotate();
				node = (OSRedBlackTreeNode<D>)root;
			}
			else{
				uncle = (OSRedBlackTreeNode<D>)(p.left);
				if(uncle != null && uncle.getColor() == OSRedBlackTreeNode.RED){
					uncle.setColor(OSRedBlackTreeNode.BLACK);
					p.setColor(OSRedBlackTreeNode.RED);
					p.RightRotate();
					p = (OSRedBlackTreeNode<D>)(node.parent);
					uncle = (OSRedBlackTreeNode<D>)(p.left);
				}
				uncleLeft = ((OSRedBlackTreeNode<D>)(uncle.right));
				uncleRight = ((OSRedBlackTreeNode<D>)(uncle.left));
				if(uncleRight.getColor() == OSRedBlackTreeNode.BLACK 
						&& uncleLeft.getColor() == OSRedBlackTreeNode.BLACK){
					uncle.setColor(OSRedBlackTreeNode.RED);
					node = p;
				}
				else if(uncleLeft.getColor() == OSRedBlackTreeNode.BLACK){
					uncleRight.setColor(OSRedBlackTreeNode.BLACK);
					uncle.setColor(OSRedBlackTreeNode.RED);
					uncle.LeftRotate();
					uncle = (OSRedBlackTreeNode<D>)(p.left);
				}
				uncle.setColor(p.getColor());
				p.setColor(OSRedBlackTreeNode.BLACK);
				((OSRedBlackTreeNode<D>)(uncle.left)).setColor(OSRedBlackTreeNode.BLACK);
				p.RightRotate();
				node = (OSRedBlackTreeNode<D>)root;
			}
		}
		node.setColor(OSRedBlackTreeNode.BLACK);
	}
}
