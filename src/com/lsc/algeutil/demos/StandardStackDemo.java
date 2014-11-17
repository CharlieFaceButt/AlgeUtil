package com.lsc.algeutil.demos;

import com.lsc.algeutil.structures.basic.StandardStack;

public class StandardStackDemo extends Demo{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		StandardStack ss = new StandardStack(10);
		ss.push(new String("mama"));
		ss.push(new Integer(9999));
		System.out.println(ss.toString());
		try {
			ss.pop();
			System.out.println(ss.toString());
			ss.pop();
			System.out.println(ss.toString());
			ss.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
