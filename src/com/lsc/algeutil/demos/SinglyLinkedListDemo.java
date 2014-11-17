package com.lsc.algeutil.demos;

import com.lsc.algeutil.structures.basic.SinglyLinkedList;

public class SinglyLinkedListDemo extends Demo{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.Insert("blublu");
		list.Insert("hollydai");
		list.Insert("charlieliu");
		list.Insert("mama");
		System.out.println("list has \"blublu\"? " + list.Search("blublu"));
		System.out.println("list has \"huolimeng\"? " + list.Search("huolimeng"));
		list.Delete("charlieliu");
		System.out.println(list);
		list.Delete("blublu");
		System.out.println(list);
		System.out.println("list has \"blublu\"? " + list.Search("blublu"));
	}

	
}
