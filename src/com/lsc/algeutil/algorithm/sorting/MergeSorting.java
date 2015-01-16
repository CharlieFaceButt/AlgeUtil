package com.lsc.algeutil.algorithm.sorting;

public class MergeSorting implements IntSorting {

	@Override
	public int[] sort(int[] list) {
		// TODO Auto-generated method stub
		int len = list.length;
		merge_sort(list, 0, len - 1);
		return list;
	}
	
	public int[] customizedSort(int[] list, int start, int end){
		merge_sort(list,start,end);
		return list;
	}
	
	private int[] merge_sort(int[] list, int start, int end){
		if(start < end){
			int divide = (start + end) / 2;
			list = merge_sort(list, start, divide);
			list = merge_sort(list, divide + 1, end);
			merge(list, start, divide, end);
		}
		return list;
	}
	/**
	 * Merge the separate parts of the list
	 * @param list
	 * @param start, index of the first element
	 * @param divide, index of the divider element
	 * @param end, index of the last element
	 */
	private void merge(int[] list, int start, int divide, int end){
		if(list == null) return;
		
		int lLength = divide - start + 1;
		int rLength = end - divide;
		int[] Llist = new int[lLength + 1];
		int[] Rlist = new int[rLength + 1];
		for(int i = 0 ; i < lLength ; i ++)
			Llist[i] = list[start + i];
		for(int j = 0 ; j < rLength ; j ++)
			Rlist[j] = list[divide + j + 1];
		Llist[lLength] = Integer.MAX_VALUE;
		Rlist[rLength] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k = start ; k <= end ; k ++){
			if(Llist[i] < Rlist[j]){
				list[k] = Llist[i];
				i ++;
			}
			else{
				list[k] = Rlist[j];
				j ++;
			}
		}
	}

}
