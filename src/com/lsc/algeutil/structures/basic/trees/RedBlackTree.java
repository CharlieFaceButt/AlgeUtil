package com.lsc.algeutil.structures.basic.trees;

/**
 * A Red-Black Tree is a binary tree that are balanced by following principles:<br>
 * 	- Node have color of either RED or BLACK<br>
 * 	- Root is BLACK<br>
 * 	- Leaves, which must be null, are BLACK<br>
 * 	- If a node is RED, both of its child must be BLACK<br>
 * 	- All paths across descendant nodes of the same node should contains same <br>
 * amount of BLACK nodes 
 * @author charlieliu
 *
 * @param <D> defines the type of data the tree want to store
 */
public class RedBlackTree<D> extends StandardBinaryTree<D> {
	
	@Override
	public D Insert(Integer key, D data) {
		/*parent of insert node*/
		RedBlackTreeNode<D> parentNode = null;
		/*node that check the key value*/
		RedBlackTreeNode<D> node = (RedBlackTreeNode<D>)root;
		/*locate the insert position*/
		while(node != null){
			parentNode = node;
			if(key < node.getKey()) node = (RedBlackTreeNode<D>)(node.left);
			else if(key > node.getKey()) node = (RedBlackTreeNode<D>)(node.right);
			else{
				D oldData = node.getData();
				node.setData(data);
				return oldData;
			}
		}
		
		/*create node*/
		RedBlackTreeNode<D> insert = new RedBlackTreeNode<D>(
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
	
	/**
	 * make sure the tree follow the red-black tree principle after insert
	 * @param insert
	 */
	protected void RBInsertFixUp(RedBlackTreeNode<D> insert){
		
		/*parent node*/
		RedBlackTreeNode<D> p = (RedBlackTreeNode<D>)(insert.parent);
		/*uncle node that has the same parent of insert's parent*/
		RedBlackTreeNode<D> uncle = null;
		
		/*When the parent is BLACK, the work is done */
		while(p !=null && p.getColor() == RedBlackTreeNode.RED){
			/*parent is the left child of grandparent*/
			if(p == p.parent.left){
				
				uncle = (RedBlackTreeNode<D>)(p.parent.right);
				
				/*parent and uncle are both RED, set them BLACK and set grandparent RED*/
				if(uncle != null && uncle.getColor() == RedBlackTreeNode.RED){
					p.setColor(RedBlackTreeNode.BLACK);
					uncle.setColor(RedBlackTreeNode.BLACK);
					insert = ((RedBlackTreeNode<D>)(p.parent));
					insert.setColor(RedBlackTreeNode.RED);
				}
				/*When uncle is BLACK and parent is RED, parent set BLACK and grand parent
				 * set RED, then right rotate from grandparent*/
				else{
					if(insert == p.right){
					insert = p;
					insert.LeftRotate();
					}
					p = (RedBlackTreeNode<D>)(insert.parent);
					p.setColor(RedBlackTreeNode.BLACK);
					p = (RedBlackTreeNode<D>)(p.parent);
					p.setColor(RedBlackTreeNode.RED);
					p.RightRotate(); 
				}
			}
			/*same as the if clause, reverse the left and right*/
			else{
				uncle = (RedBlackTreeNode<D>)(p.parent.left);
				if(uncle != null && uncle.getColor() == RedBlackTreeNode.RED){
					p.setColor(RedBlackTreeNode.BLACK);
					uncle.setColor(RedBlackTreeNode.BLACK);
					insert = ((RedBlackTreeNode<D>)(p.parent));
					insert.setColor(RedBlackTreeNode.RED);
				}
				else{
					if(insert == p.left){
					insert = p;
					insert.RightRotate();
					}
					p = (RedBlackTreeNode<D>)(insert.parent);
					p.setColor(RedBlackTreeNode.BLACK);
					p = (RedBlackTreeNode<D>)(p.parent);
					p.setColor(RedBlackTreeNode.RED);
					p.LeftRotate(); 
				}
			}
			/*find parent parent*/
			p = (RedBlackTreeNode<D>)(insert.parent);
		}
		/*make sure the root is BLACK*/
		((RedBlackTreeNode<D>)root).setColor(RedBlackTreeNode.BLACK);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public D Delete(Integer key) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		
		/*the node you want to delete*/
		RedBlackTreeNode<D> node = (RedBlackTreeNode<D>)(root.Search(key));
		/*node not exist*/
		if(node == null) return null;
		
		/*help do the deletion*/
		RedBlackTreeNode<D> delete = null;
		/*distinguish whether node has two child, delete itself if it doesn't,
		 * otherwise replace itself with its successor and delete its successor*/
		if(node.left == null || node.right == null)
			delete = node;
		else delete = (RedBlackTreeNode<D>)(node.Successor());
		
		/*get the child of the delete node*/
		RedBlackTreeNode<D> child = null;
		if(delete.left != null) child = (RedBlackTreeNode<D>)(delete.left);
		else child = (RedBlackTreeNode<D>)(delete.right);
		
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
		if(delete.getColor() == RedBlackTreeNode.BLACK)
			RBDeleteFixUp(child);
		return oldData;
	}
	
	/**
	 * make sure the tree follow the red-black tree principle after delete
	 * @param node
	 */
	protected void RBDeleteFixUp(RedBlackTreeNode<D> node){
		
		if(node == null) return;
		
		RedBlackTreeNode<D> p = null;
		RedBlackTreeNode<D> uncle = null;
		RedBlackTreeNode<D> uncleLeft = null;
		RedBlackTreeNode<D> uncleRight = null;
		
		while(node != root && node.getColor() != RedBlackTreeNode.BLACK){
			
			p = (RedBlackTreeNode<D>)(node.parent);
			
			/*if the node is its parent's left child*/
			if(node == p.left){
				uncle = (RedBlackTreeNode<D>)(p.right);
				if(uncle != null && uncle.getColor() == RedBlackTreeNode.RED){
					uncle.setColor(RedBlackTreeNode.BLACK);
					p.setColor(RedBlackTreeNode.RED);
					p.LeftRotate();
					p = (RedBlackTreeNode<D>)(node.parent);
					uncle = (RedBlackTreeNode<D>)(p.right);
				}
				uncleLeft = ((RedBlackTreeNode<D>)(uncle.left));
				uncleRight = ((RedBlackTreeNode<D>)(uncle.right));
				if(uncleLeft.getColor() == RedBlackTreeNode.BLACK 
						&& uncleRight.getColor() == RedBlackTreeNode.BLACK){
					uncle.setColor(RedBlackTreeNode.RED);
					node = p;
				}
				else if(uncleRight.getColor() == RedBlackTreeNode.BLACK){
					uncleLeft.setColor(RedBlackTreeNode.BLACK);
					uncle.setColor(RedBlackTreeNode.RED);
					uncle.RightRotate();
					uncle = (RedBlackTreeNode<D>)(p.right);
				}
				uncle.setColor(p.getColor());
				p.setColor(RedBlackTreeNode.BLACK);
				((RedBlackTreeNode<D>)(uncle.right)).setColor(RedBlackTreeNode.BLACK);
				p.LeftRotate();
				node = (RedBlackTreeNode<D>)root;
			}
			else{
				uncle = (RedBlackTreeNode<D>)(p.left);
				if(uncle != null && uncle.getColor() == RedBlackTreeNode.RED){
					uncle.setColor(RedBlackTreeNode.BLACK);
					p.setColor(RedBlackTreeNode.RED);
					p.RightRotate();
					p = (RedBlackTreeNode<D>)(node.parent);
					uncle = (RedBlackTreeNode<D>)(p.left);
				}
				uncleLeft = ((RedBlackTreeNode<D>)(uncle.right));
				uncleRight = ((RedBlackTreeNode<D>)(uncle.left));
				if(uncleRight.getColor() == RedBlackTreeNode.BLACK 
						&& uncleLeft.getColor() == RedBlackTreeNode.BLACK){
					uncle.setColor(RedBlackTreeNode.RED);
					node = p;
				}
				else if(uncleLeft.getColor() == RedBlackTreeNode.BLACK){
					uncleRight.setColor(RedBlackTreeNode.BLACK);
					uncle.setColor(RedBlackTreeNode.RED);
					uncle.LeftRotate();
					uncle = (RedBlackTreeNode<D>)(p.left);
				}
				uncle.setColor(p.getColor());
				p.setColor(RedBlackTreeNode.BLACK);
				((RedBlackTreeNode<D>)(uncle.left)).setColor(RedBlackTreeNode.BLACK);
				p.RightRotate();
				node = (RedBlackTreeNode<D>)root;
			}
		}
		node.setColor(RedBlackTreeNode.BLACK);
	}
}
