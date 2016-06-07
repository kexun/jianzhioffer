package com.offer;

/**
 * 数组中只出现一次的数字，要去时间O(n) 空间O(1)
 * 这个题目，主要是考察位运算的能力。因为所有数字都是成对出现的，
 * 所有通过异或操作 相同的数字互相抵消为0。最后剩下两个不同的数字，
 * 然后通过两个不同数字的异或操作后的值，判断这个值的二进制中，第一个
 * 出现1的位置，然后对所有数字判断这个位置中是否出现1来把这个数字分成
 * 两个子数组，每个子数组只包含一个不同的数字，因此对所有数字做异或
 * 操作以后，就能得到这个值。
 * @author kexun
 *
 */
public class Day28 {

	public static void main(String[] args) {

		Day28 d = new Day28();
		int[] array = {
			1,3,6,7,3,1,6,8,0,8,0,2	
		};
		d.find2NumAppearOnce(array);
	}
	
	public void find2NumAppearOnce(int[] array) {
		
		int length = array.length;
		if (length < 2)
			return;
		
		int num = 0;
		for (int i = 0; i < length; i++) {
			num ^= array[i];
		}
		
		int indexOfBit1 = findIndexOfBit1(num);
		
		int v1 = 0;
		int v2 = 0;
		for (int j = 0; j < length; j++) {
			if (isBit1(array[j], indexOfBit1)) {
				v1 ^= array[j];
			} else {
				v2 ^= array[j];
			}
		}
		
		System.out.println(v1);
		System.out.println(v2);
		
	}

	/**
	 * 找到二进制数据中，第一位1的下标
	 * @param num
	 * @return
	 */
	public int findIndexOfBit1(int num) {
		
		int index = 0;
		
		while (num != 0 && (num & 1) == 0) {
			num = num >>> 1;
			index++;
		}
		
		return index;
	}
	
	/**
	 * 判断这个数在 特定的下标下 是不是1
	 * @param num
	 * @param index
	 * @return
	 */
	public boolean isBit1(int num, int index) {
		num = num >>> index;
		return (num&1)==1;
	}
	
}
