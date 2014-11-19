package com.lsc.algeutil.demos.maps;

import com.lsc.algeutil.demos.Demo;
import com.lsc.algeutil.structures.basic.maps.FullDomainHash;
import com.lsc.algeutil.structures.basic.maps.MultiplyHash;
import com.lsc.algeutil.structures.basic.maps.StandardHashMap;

/**
 * Demo for StandardHashMap
 * @author charlieliu
 *
 */
public class SHMDemo extends Demo {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long domain = 0xffffffffl;
		StandardHashMap<String, String> map = new StandardHashMap<String, String>(new FullDomainHash<String>(domain));
		map.Insert("holi", "philosopher");
		map.Insert("charlie", "engineer");
		System.out.println("has philosopher? " + map.SearchByKey("holi"));
		System.out.println(map.toString());
		map.Delete("charlie");
		System.out.println("has philosopher? " + map.SearchByKey("holi"));
		System.out.println(map.toString());
		System.out.println("data has key holi is:" + map.getData("holi"));
		map.Insert("holi", "teacher");
		System.out.println("data has key holi is:" + map.getData("holi"));
	}

}
