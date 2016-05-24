package com.offer;

/**
 * 旋转数组查最小值
 * @author kexun
 *
 */
public class Day06 {

	
	private static int[] array = {
		1,1,1,1,0,1,1,1,1
	};
	
	public int min(int[] array) {
		
		int start = 0;
		int end = array.length - 1;
		
		int min = 0;
		while (end - start > 1) {
			
			if (array[start] > array[end]) {
				
				int mid = (start+end)/2;
				int mvalue = array[mid];
				
				if (array[start] > mvalue) {
					end = mid;
				}
				
				if (array[start] <= mvalue) {
					start = mid;
				}
				
				
			} else if (array[start] == array[end]) {
				min = array[start];
				for (int i = start+1; i <= end; i++) {
					if (min > array[i])
						min = array[i];
				}
				return min;
			}
		}
		
		if (array[start] > array[end]) {
			min = array[end];
		} else {
			min = array[start];
		}
		
		return min;
	}
	
	
	
	
	public static void main(String[] args) {
		Day06 d = new Day06();
		int min = d.min(array);
		System.out.println(min);
	}

}
