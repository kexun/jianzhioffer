package com.offer;


public class Day06 {

	
	private static int[] array = {
		1,1,1,1,0,1,1,1,1
	};

	/**
	 * 旋转数组查最小值
	 * @author kexun
	 *
	 */
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
	
	/**
	 * 递归调用， 但效率不可接受
	 * @param n
	 * @return
	 */
	public int fibo(int n) {
		
		System.out.println(n);
		
		if (n <= 0)
			return 0;
		
		if (n == 1)
			return 1;
		
		return fibo(n-1) + fibo(n-2);
	}
	
	/**
	 * 位运算  统计一个数的二进制表示法中 1的个数
	 * @param n
	 * @return
	 */
	public int numberOf1(int n) {
		
		int count = 0;
		
		while (n != 0) {
			
			if ((n&1) == 1) {
				count++;
			}
			n = n >> 2;
		}
		return count;
	}
	
	/**
	 * 考虑到负数的情况
	 * @param n
	 * @return
	 */
	public int negNumberOf1(Integer n) {
		int count = 0;
		int index = 1;
		while (index != 0) {
			
			int value = (n & index);
			
			if ((n & index) != 0) {
				count++;
			}
			index = index << 1;
		}
		return count;
	}
	
	/**
	 * 把原数值-1 再通过&操作 能计算出有多少个1
	 * @param n
	 * @return
	 */
	public int numOf1(int n) {
		
		int count = 0;
		
		while (n != 0) {
			count++;
			
			n = (n - 1)&n;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		Day06 d = new Day06();
//		int min = d.min(array);
//		System.out.println(min);
		
//		int fibo = d.fibo(20);
//		System.out.println(fibo);
		
		System.out.println(d.numberOf1(1));
		System.out.println(d.negNumberOf1(-2));
		System.out.println(d.numberOf1(3));
		System.out.println(d.numberOf1(4));
		System.out.println(d.numOf1(5));
	}

}
