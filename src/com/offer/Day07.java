package com.offer;

public class Day07 {

	public static void main(String[] args) {

		Day07 d = new Day07();
		double value = d.power(5, 5);
		System.out.println(value);
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
	

}
