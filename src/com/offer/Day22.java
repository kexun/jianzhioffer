package com.offer;

/**
 * 求连续数组的最大和
 * @author kexun
 *
 */
public class Day22 {

	public static void main(String[] args) {
		
		int[] array = {
				1,-2,3,10,-4,7,2,-5,-20,1,1,90
		};
		Day22 d = new Day22();
		d.findBigestSumOfSubArray(array);
		
	}
	
	/**
	 * 对数组进行叠加， 当出现和小于0的时候，最大数组就不可能从这里开始，因此从新开始设置子数组的起点值
	 * 当出现和大于最大值的时候，将最大值设置为当前和，并且将当前下标设置为子数组的结尾。如此循环下去。
	 * @param array
	 */
	public void findBigestSumOfSubArray(int[] array) {
		
		boolean isRestart = false;
		int bigestSum = 0;
		int bigStart = 0;
		int bigEnd = 0;
		int reStart = 0;
		int sum = 0;
		int length = array.length;
		
		for (int i = 0; i < length; i++) {
			
			if (isRestart) {
				sum = 0;
				reStart = i;
			} 
			
			sum += array[i];
			if (sum < 0) {
				isRestart = true;
			} else {
				isRestart = false;
			}
			
			if (sum > bigestSum) {
				bigestSum = sum;
				bigStart = reStart;
				bigEnd = i;
			}
		}
		System.out.println(bigestSum);
		print(array, bigStart, bigEnd);
	}
	
	public void print(int[] array, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(array[i]+",");
		}
	}

}
