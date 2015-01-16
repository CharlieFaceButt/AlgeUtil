package com.lsc.algeutil.algorithm.sorting;

public class InsertionSorting implements IntSorting {

	@Override
	public int[] sort(int[] list) {
		// TODO Auto-generated method stub
		int key = 0;
		for(int i = 1 ; i < list.length ; i ++){
			key = list[i];
			int j = i - 1;
			while(j >= 0 && list[j] > key){
				list[j+1] = list[j];
				j --;
			}
			list[j + 1] = key;
		}
		return null;
	}

}
