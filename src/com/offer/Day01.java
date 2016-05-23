package com.offer;

/**
 * 在给定的二维数组中，从左往右，从上往下值依次变大。然后给定一个数值，判断是否保函在此数组中。
 * @author kexun
 *
 */
public class Day01 {

	private static int[][] array = {
			{1,2,8,9},
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
	};
	
	private static boolean contains(int key, int[][] array) {
		
		int x = 0;
		int y = array[0].length - 1;
		
		int value = array[x][y];
		while (value != key) {
			
			if (x>=3 || y<=0) {
				return false;
			}
			
			if (value > key) {
				y--;
			}
			if (value < key) {
				x++;
			}
			System.out.println(x + "-----" + y);
			value = array[x][y];
		}
		
		if (value == key) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {

		boolean result = contains(10, array);
		System.out.println(result);
		
	}

}
