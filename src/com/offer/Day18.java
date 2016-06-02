package com.offer;

/**
 * 数组的全排列
 * @author kexun
 *
 */
public class Day18 {

	public static void main(String[] args) {
		char[] array = {
				'a','b','c'
		};
		
		Day18 d = new Day18();
		d.allSort(array);
	}
	
	public void allSort(char[] array) {
		
		if (array.length == 0)
			return;
		sort(array, 0);
	}
	
	/**
	 * 通过递归的方式， 将数组分成两部分， 第一个字符 和 后面一部分， 然后将第一个字符与后面全都互换一边
	 * 如此递归调用，通过 n！此交换 可以将数组全排列一边
	 * @param array
	 * @param begin
	 */
	public void sort(char[] array, int begin) {
		
		int length = array.length;
		if (begin == length) {
			print(array);
		} else {
			for (int i = begin; i < length; i++) {
				
				char temp = array[i];
				array[i] = array[begin];
				array[begin] = temp;
				
				sort(array, begin+1);
				
				temp = array[i];
				array[i] = array[begin];
				array[begin] = temp;
			}
		}
		
	}
	
	public void print(char[] array) {
		for (char c : array) {
			System.out.print(c+",");
		}
		System.out.println();
	}

}
