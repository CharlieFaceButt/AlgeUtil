package com.lsc.algeutil.demos.maps;

import com.lsc.algeutil.structures.basic.KeyTaggedDataBean;

public class StringDAMData extends KeyTaggedDataBean<Integer,String>{

	public static int DEFAULT_RANGE = 512;
	
	public StringDAMData(String data) {
		super(null,data);
		this.key = generateKey(data);
	}

	@Override
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

}
