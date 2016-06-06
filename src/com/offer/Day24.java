package com.offer;

/**
 * 第一个只出现一次的字符
 * 
 * 这题的主要思路是 建立一个hashmap 大小为256  因为char的长度为8，
 * 然后第一次扫描，把字符作为key，出现的次数作为value。
 * 第二次扫描，读取到第一个value=1的key 就是第一个只出现一次的字符。
 * 时间复杂度为O(n)
 * @author kexun
 *
 */
public class Day24 {

	public static void main(String[] args) {
		
		Day24 d = new Day24();
		d.firstChar("asd2fadsafds3ufaswwwereadg");
	}
	
	/**
	 * 一个简易的hashmap  因为char大小为8 所以数组大小为256
	 * @author kexun
	 *
	 */
	class HashMap{
		
		int[] table = new int[256];
		
		public void put(char key, int value) {
			table[key] = value;
		}
		
		public int get(char key) {
			return table[key];
		}
	}
	
	public void firstChar(String str) {
		
		HashMap map = new HashMap();
		char[] array = str.toCharArray();
		for (char c : array) {
			int count = map.get(c);
			map.put(c, ++count);
		}
		
		for (char c : array) {
			int count = map.get(c);
			if (count == 1) {
				System.out.println(c);
				break;
			}
		}
	}

}
