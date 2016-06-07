package com.offer;

/**
 * 数字在排序数组中出现的次数
 * @author kexun
 *
 */
public class Day26 {

	public static void main(String[] args) {
		
		Day26 d = new Day26();
		int[] array = {
				1,2,3,4,4,4,4,4,4,5,6,7
		};
		int count = d.countNum(array, 7);
		System.out.println(count);
	}

	/**
	 * 计算数字在数组中出现的此时， 通过二分查找的方法，查找到重复数字在数组中，
	 * 出现的第一个下标和最后一个小标值。
	 * @param array
	 * @param k
	 * @return
	 */
	public int countNum(int[] array, int k) {
		
		if (array.length == 0)
			return -1;
		
		int f = firstIndex(array, k, 0, array.length-1);
		int l = lastIndex(array, k, 0, array.length-1);
		
		if (f == -1 || l == -1)
			return 0;
		return l-f+1;
	}
	
	/**
	 * 查找到第一个下标值
	 * @param array
	 * @param k
	 * @return
	 */
	public int firstIndex(int[] array, int k, int start, int end) {
		

		if (start > end)
			return -1;
		
		int middle = (start+end)/2;
		int mData = array[middle];
		
		if (mData == k) {
			if ((middle > 0 && array[middle-1] != k) || middle == 0) {
				return middle;
			} else {
				end = middle - 1;
			}
		} else if (mData > k) {
			end = middle-1;
		} else {
			start = middle+1;
		}
		
		return firstIndex(array, k, start, end);
		
	}
	
	/**
	 * 查找到最后一个下标
	 * @param array
	 * @param k
	 * @return
	 */
	public int lastIndex(int[] array, int k, int start, int end) {
		
		if (start > end)
			return -1;
		
		int middle = (start+end)/2;
		int mData = array[middle];
		
		if (mData == k) {
			if ((middle < array.length - 1 && array[middle+1] != k) || middle == array.length - 1) {
				return middle;
			} else {
				start = middle + 1;
			}
		} else if (mData > k) {
			end = middle-1;
		} else {
			start = middle+1;
		}
		
		return lastIndex(array, k, start, end);
		
	}
}
