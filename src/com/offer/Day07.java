package com.offer;

public class Day07 {

	public static void main(String[] args) {

		Day07 d = new Day07();
//		double value = d.power(5, 5);
//		System.out.println(value);
		
		d.print1ToMax(20);
		
		
	}
	
	/**
	 * 求一个数值的整数次方  通过递归的方式  实现类似于菲波拿捏数列
	 * @param base
	 * @param exp
	 * @return
	 */
	public double power(double base, int exp) {
		
		if (exp == 0) {
			return 1;
		}
		
		if (exp == 1) {
			return base;
		}
		
		double value = 1.0;
		value = power(base, exp >> 1);
		value *= value;
		if ((exp & 0x1) == 1) {
			value *= base;
		}
		return value;
	}
	
	/**
	 * 给定一个整数n，从1打印到n位最大的数 如1  打印1-9
	 * @param n
	 */
	public void print1ToMax(int n) {
		
		char[] array = new char[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = '0';
		}
		
		while (increaseBy1(array)) {
			printNum(array);
			System.out.println();
		}
	}
	
	/**
	 * 考虑到大数问题，用char数组模拟整数的增加，每次+1
	 * @param array
	 * @return
	 */
	public boolean increaseBy1(char[] array) {
		
		int length = array.length;
		int takeOver = 0;
		
		for (int i = length-1; i >= 0; i--) {
			
			int sum = array[i] - '0' + takeOver;
			
			if (i == length - 1) {
				sum++;
			}
			
			if (sum == 10) {
				if (i == 0) {
					return false;
				} else {
					sum = 0;
					takeOver = 1;
					array[i] = '0';
				}
			} else {
				array[i] = (char) ('0' + sum);
				break;
			}
			
		}
		
		return true;
		
	}

	/**
	 * 递归打印数字，并且数字不能以0开头
	 * @param array
	 */
	public void printNum(char[] array) {

		int index = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != '0') {
				index = i;
				break;
			}
		}
		print(array, index);
	}
	
	
	public void print(char[] array, int index) {
		
		if (index >= array.length)
			return;
		
		System.out.print(array[index]);
		print(array, ++index);
	}
}
