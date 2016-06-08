package com.offer;

/**
 * 在一个递增数组中，找两个和为s的数
 * @author kexun
 *
 */
public class Day29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Day29 d = new Day29();
		int[] array = {
				1,2,4,7,11,15
		};
		d.findSumEqS(array, 15);
	}

	/**
	 * 维护两个指针 头和尾
	 * 和大于s的时候，尾指针向前移一位，小于s的时候，头指针向前移一位
	 * @param array
	 * @param s
	 */
	public void findSumEqS(int[] array, int s) {
		
		int length = array.length;
		int indexFirst = 0;
		int indexLast = length - 1;
		
		while (indexFirst < indexLast) {
			
			int sum = array[indexFirst] + array[indexLast];
			if (sum > s) {
				indexLast--;
			} else if (sum < s) {
				indexFirst++;
			} else {
				System.out.println(array[indexFirst]);
				System.out.println(array[indexLast]);
				break;
			}
		}
		
	}
}
