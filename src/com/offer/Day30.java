package com.offer;

/**
 * 反转单词顺序  题目要求如 i am a student.  
 * 反转后 student. a am i
 * @author kexun
 *
 */
public class Day30 {

	public static void main(String[] args) {
		Day30 d = new Day30();
		StringBuffer str = new StringBuffer("i am a student.");
		d.reverse(str, 0, str.length()-1);
		System.out.println(str);
		d.singleReverse(str);
		System.out.println(str);
	}
	
	/**
	 * 通过两次反转，第一次反转整个string，结果为 .tneduts a ma i
	 * 然后对每个单词再做一次反转即可得到结果
	 * @param str
	 */
	public void reverse(StringBuffer sb, int start, int end) {
		
		if (sb.length() == 0)
			return;
		// 第一次对整个string反转
		while (start < end) {
			String endStr = sb.substring(end, end+1);
			String startStr = sb.substring(start, start+1);
			sb.replace(end, end+1, startStr);
			sb.replace(start, start+1, endStr);
			start++;
			end--;
		}
		
	}
	
	// 第二次对单个词反转
	public void singleReverse(StringBuffer sb) {
		
		int start = 0;
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (ch == ' ') {
				reverse(sb, start, i-1);
				start = i+1;
			}
		}
		
	}

}
