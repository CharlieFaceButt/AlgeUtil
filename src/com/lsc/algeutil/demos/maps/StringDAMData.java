package com.lsc.algeutil.demos.maps;

import com.lsc.algeutil.structures.KeyTaggedDataParents;

public class StringDAMData extends KeyTaggedDataParents<Integer,String>{

	private String data;
	private Integer key = -1;
	public static int DEFAULT_RANGE = 512;
	
	public StringDAMData(String data) {
		super();
		this.data = data;
		this.key = generateKey(data);
	}


	public Integer getKey() {
		// TODO Auto-generated method stub
		return key;
	}


	public Integer generateKey(String data) {
		// TODO Auto-generated method stub
		if(data == null) return -1;
		int key = -1;
		for(int i=0 ; i<data.length() ; i++){
			key += (int)data.charAt(i);
		}
		key %= DEFAULT_RANGE;
		return key;
	}


	public String getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
