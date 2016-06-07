package com.offer;

/**
 * 丑数  何为丑数？ 只含因子2,3,5的数称为丑数，如2,4,6,8。
 * 因此判断一个数是不是因子，只要连续除2,3,5 直到最终结果为1
 * @author kexun
 *
 */
public class Day23 {

	public static void main(String[] args) {
		Day23 d = new Day23();
		int val = d.getUglyNmu(1500);
		System.out.println(val);
	}
	
	public int getUglyNmu(int index) {
		
		if (index <= 0)
			return 0;
		
		// 因为数组第一个值是1， 所以获取到第n个值的话，数组长度要N+1才能获得第n个丑数
		index++;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int nextIndex = 1;
		int[] array = new int[index];
		array[0] = 1;
		
		/**
		 * 循环获取第n个丑数
		 */
		while (nextIndex < index) {
			
			/**
			 * 这里有3条线，2的倍数，3的倍数，5的倍数各自的下标
			 * 计算下一个倍数的值，并且求这3个值中最小的数，这样
			 * 才能保证丑数是从小到大排序的。
			 */
			int val2 = array[index2] * 2;
			int val3 = array[index3] * 3;
			int val5 = array[index5] * 5;
			int min = min(val2, val3, val5);
			array[nextIndex] = min;
			
			/**
			 * 得到下一个丑数以后，重新计算这3条线。分别把下标移到最靠近当前
			 * 丑数的位置。
			 */
			while (array[index2] * 2 <= min && array[index2] != 0) {
				index2++;
			}
			while (array[index3] * 3 <= min && array[index3] != 0) {
				index3++;
			}
			while (array[index5] * 5 <= min && array[index5] != 0) {
				index5++;
			}
			
			nextIndex++;
		}
		
		
		return array[nextIndex-1];
	}
	
	public int min(int val1, int val2, int val3) {
		
		int min = val1 < val2 ? val1 : val2;
		min = min < val3 ? min : val3;
		return min;
	}

}
