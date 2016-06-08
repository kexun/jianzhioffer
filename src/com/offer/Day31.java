package com.offer;

/**
 * n个骰子的点数    打印n个筛子的点数的和，出现的概率
 * @author kexun
 *
 */
public class Day31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day31 d = new Day31();
		d.printProbability(5);
	}

	public void printProbability(int num) {
		
		int[] array = new int[5*num+1];
		
		printProbability(num, array, 0, 6*num);
		print(array, num);
	}
	
	// 这里用递归调用的方式   但是时间效率有点低
	public void printProbability(int num, int[] array, int sum, int max) {
		
		if (num == 1) {
			for (int i = 1; i <= 6; i++) {
				int value = sum + i;
				array[max-value]++;
			}
		} else {
			for (int i = 1; i <= 6; i++) {
				int value = sum + i;
				printProbability(num-1, array, value, max);
			}
		}
	}
	
	public void print(int[] array, int num) {
		int max = 6*num;
		for (int i=0; i<array.length; i++) {
			if (array[i] != 0) {
				System.out.println(max-i + "--" + array[i]);
			}
		}
	}
}
