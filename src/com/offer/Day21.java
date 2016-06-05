package com.offer;

/**
 * 最小的k个数字
 * @author kexun
 *
 */
public class Day21 {

	public static void main(String[] args) {
		int[] array = {
			5,7,3,0,8,2,3,8,6,1,4,8
		};
		
		Day21 d = new Day21();
		d.method1(array, 3);
	}
	
	/**
	 * 利用快排思想，第k位置的左边都小于他  右边都大于他
	 * @param array
	 */
	public void method1(int[] array, int k) {

		int length = array.length;
		if (length == 0)
			return;

		int start = 0;
		int end = length - 1;
		int position = position(array, start, end);
		
		while (position != k-1) {
			if (position > k - 1) {
				end = position - 1;
				position = position(array, start, end);
			} else {
				start = position + 1;
				position = position(array, start, end);
			}
		}
		
		print(array, position);
	}
	
	/**
	 * 还是之前的做法 快排思想， 返回基准值的位置
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int position(int[] array, int start, int end) {
		
		int base = array[start];
		
		while (start < end) {
			
			// 从右往左找小于基数的值，并互换位置
			while (start < end && array[end] >= base) {
				end--;
			}
			
			if (start < end) {
				array[start] = array[end];
				start++;
			}
			
			// 从左往右找大于基数的值，并互换位置
			while (start < end && array[start] < base) {
				start++;
			}
			
			if (start < end) {
				array[end] = array[start];
				end--;
			}
			
		}
		
		array[start] = base;
		return start;
		
	}
	
	public void print(int[] array, int k) {
		int length = array.length;
		if (k > length-1)
			return;
		
		for (int i=0; i<=k; i++) {
			System.out.print(array[i]+",");
		}
	}
	

}
