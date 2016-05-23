package com.offer;

/**
 * 快速排序
 * @author kexun
 *
 */
public class Day05 {

	private static int count = 0;
	
	public static void main(String[] args) {

		int[] array = {5,4,3,2,1};
		Day05 d = new Day05();
		array = d.partition(array, 0, array.length - 1);
//		for (int a : array) {
//			System.out.println(a);
//		}
		System.out.println(array.length);
		System.out.println(count);
	}
	
	
	public int[] partition(int[] array, int i, int j) {
		
		if (j - i <= 0 ) {
			return array;
		}
		
		int start = i;
		int end = j;
		int base = array[start];
		while (start < end) {
//			count++;
			// 先从右向左找小于基数的值
			while (start < end && array[end] >= base) {
				count++;
				end--;
			}
			if (start < end) {
				array[start] = array[end];
				start++;
			}
			
			// 先从左向右找小大于基数的值
			while (start < end && array[start] < base) {
				count++;
				start++;
			}
			if (start < end) {
				array[end] = array[start];
				end--;
			}
			
		}
		
		array[start] = base;
		partition(array, i, start - 1);
		partition(array, end + 1, j);
		return array;
	}

}
 