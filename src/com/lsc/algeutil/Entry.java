package com.lsc.algeutil;

import java.util.HashMap;

import com.lsc.algeutil.demos.Demo;
import com.lsc.algeutil.demos.DoubleLinkedListDemo;
import com.lsc.algeutil.demos.SinglyLinkedListDemo;
import com.lsc.algeutil.demos.StandardStackDemo;
import com.lsc.algeutil.demos.maps.DAMDemo;
import com.lsc.algeutil.demos.maps.SHMDemo;

/**
 * Main entry to test algorithms
 * Algorithm demo are presented in package demos and are all linked to this class
 * @author charlieliu
 *
 */
public class Entry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo = new SHMDemo();
		demo.run();
	}

}
