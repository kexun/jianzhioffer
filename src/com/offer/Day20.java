package com.offer;

public class Day20 {

	public static void main(String[] args) {

		int[] array = {
				1,2,3,4,4,4,4,5,7,2,9,4,4,4,4,4,4,5,7,8,4
			};
		
		Day20 d = new Day20();
		int value = d.moreThanHalf(array);
		System.out.println(value);
		
	}

	public int moreThanHalf(int[]array) {
		
		int length = array.length;
		if (length == 0)
			return -1;
		
		int value = array[0];
		int count = 1;
		
		for (int i = 1; i < length; i++) {
			if (count == 0) {
				value = array[i];
				count = 1;
			} else if (value == array[i]) {
				count++;
			} else {
				count--;
			}
		}
		
		return value;
		
	}
}
