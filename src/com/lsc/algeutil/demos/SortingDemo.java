package com.lsc.algeutil.demos;

import com.lsc.algeutil.algorithm.sorting.InsertionSorting;
import com.lsc.algeutil.algorithm.sorting.IntSorting;
import com.lsc.algeutil.algorithm.sorting.MergeSorting;

public class SortingDemo extends Demo {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		int[] list = randomIntList(1000, 255, 0);
		output(list);
//		IntSorting s = new InsertionSorting();
		MergeSorting s = new MergeSorting();
		s.sort(list);
		output(list);
	}
	
	/**
	 * Generate random list of integers
	 * @param length
	 * @param max
	 * @param min
	 * @return
	 */
	private int[] randomIntList(int length, int max, int min){
		int[] l = new int[length];
		long range = max - min;
		for(int i = 0 ; i < length ; i ++){
			l[i] = min + (int)(range * Math.random());
		}
		return l;
	}

	/**
	 * Iterate the list
	 * @param list
	 */
	private void output(int[] list){
		System.out.println("list:" + list.toString());
		for(int i = 0 ; i < list.length ; i ++){
			System.out.print("" + list[i] + ",");
			if((i + 1) % 16 == 0) System.out.println();
		}
		System.out.println();
	}
}
