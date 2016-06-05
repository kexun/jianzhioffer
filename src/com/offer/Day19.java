package com.offer;

/**
 * 数组中出现次数超过一半的数字
 * @author kexun
 *
 */
public class Day19 {

	public static void main(String[] args) {

		int[] array = {
			1,2,3,4,4,4,4,5,7,2,9,4,4,4,5,7,8,4
		};
		
		Day19 d = new Day19();
		d.moreThenHalf(array);
	}
	
	/**
	 * 寻找数组中重复出现超过一半的值
	 * @param array
	 */
	public void moreThenHalf(int[] array) {
		
		int length = array.length;
		if (length == 0)
			return;
		
		int middle = length >> 1;
		int start = 0;
		int end = length - 1;
		int index = position(array, start, end);
		
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = position(array, start, end);
			} else {
				start = index + 1;
				index = position(array, start, end);
			}
		}
		
		int result = array[middle];
		System.out.println(result);
	}
	
	/**
	 * 快速排序方法，返回每次排序后的基准值位置
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int position(int[] array, int start, int end) {
		
		if (start >= end)
			return start;
		
		int base = array[start];
		
		while (start < end) {
			
			// 先从右往左找小于基数的值
			while (start < end && array[end] >= base) {
				end--;
			}
			
			if (start < end) {
				array[start] = array[end];
				start++;
			}
			
			// 从左往右找大于基数的值
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

}
