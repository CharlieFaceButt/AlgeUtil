package com.lsc.algeutil.demos.trees;

import com.lsc.algeutil.demos.Demo;
import com.lsc.algeutil.structures.basic.trees.StandardBinaryTree;

public class BTreeDemo extends Demo{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		StandardBinaryTree<String> bt = new StandardBinaryTree<String>();
		bt.Insert(3, "blublu");
		bt.Insert(5, "blingbling");
		bt.Insert(1, "blabla");
		bt.Insert(4, "charlie");
		System.out.println(bt.toString());
		System.out.println("element that has key value of 2:" + bt.Search(2));
		System.out.println("element that has key value of 2:" + bt.Search(5));
		bt.Insert(9, "holi");
		bt.Insert(7, "xixigengjiankang");
		System.out.println(bt.toString());
		System.out.println(bt.OrderedTreeWalk());
		bt.Delete(5);
		System.out.println(bt.toString());
		bt.Delete(3);
		System.out.println(bt.toString());
		System.out.println("element that has key value of 9:" + bt.Search(9));
		bt.Insert(9, "holidai");
		System.out.println("element that has key value of 9:" + bt.Search(9));
		System.out.println(bt.OrderedTreeWalk());
	}

}
