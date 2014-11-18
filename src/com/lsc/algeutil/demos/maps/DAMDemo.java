package com.lsc.algeutil.demos.maps;

import com.lsc.algeutil.demos.Demo;
import com.lsc.algeutil.structures.basic.maps.DirectAddrMap;

public class DAMDemo extends Demo{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DirectAddrMap<String> map = new DirectAddrMap<String>(StringDAMData.DEFAULT_RANGE);
		map.Insert(new StringDAMData("blublu"));
		map.Insert(new StringDAMData("bilibili"));
		map.Insert(new StringDAMData("buguabugua"));
		
		StringDAMData sdd = new StringDAMData("blingbling");
		System.out.println(map.toString());
		System.out.println("has blingbling? " + map.SearchByData(sdd.getData()));
		
		map.Insert(sdd);
		System.out.println(map.toString());
		System.out.println("has blingbling? " + map.SearchByData(sdd.getData()));
		
		int k = sdd.getKey();
		map.Delete(k);
		System.out.println(map.toString());
		System.out.println("has blingbling? " + map.SearchByData(sdd.getData()));
		
		map.DeleteByData("blublu");
		System.out.println(map.toString());
	}
}
