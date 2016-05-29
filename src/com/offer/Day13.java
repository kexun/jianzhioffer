package com.offer;

public class Day13 {

	public static void main(String[] args) {
		int[] array = {
				5,7,6,9,11,10,8
		};
		
		int[] array2 = {
				7,4,6,5
		};

		int[] array3 = {
				1,1,1,1,1,6
		};
		
		int[] array4 = {
				
		};
		
		Day13 d = new Day13();
		boolean result = d.isPostOrder2(array, 0, array.length -1); 
		System.out.println(result);

	}
	
	/**
	 * 判断摸个序列 是否为树的后续遍历  通过树的后续遍历特点来解决
	 * @param array
	 * @return
	 */
	public boolean isPostOrder(int[] array, int start, int end) {
		
		int length = array.length;
		
		if (length == 0)
			return false;
		
		if (end - start <= 2) 
			return true;
		
		int root = array[end];
		
		for (int i = start; i < end; i++) {
			
			if (i < end-1) {
				if (array[i] < root && array[i+1] >= root) {
					
					for (int z=start; z<=i; z++) {
						if (array[z] >= root)
							return false;
					}
					
					for (int j = i+1; j<end; j++) {
						if (array[j] < root)
							return false;
					}
					
					return isPostOrder(array, start, i) & isPostOrder(array, i+1, end-1);
				} 
			} else {
				if (array[end-1]<root && array[end-2]>root) {
					return false;
				} else {
					return isPostOrder(array, start, end-1);
				}
			}
			
		}
		
		return true;
	}
	
	/**
	 * 判断摸个序列 是否为树的后续遍历  通过树的后续遍历特点来解决
	 * @param array
	 * @return
	 */
	public boolean isPostOrder2(int[] array, int start, int end) {
		
		int length = array.length;
		
		if (length == 0)
			return false;
		
		if (length <= 2)
			return true;
		
		if (end - start <=2)
			return true;
		
		
		int root = array[length-1];
		int i = start;
		for (; i<end; i++) {
			if (array[i] >= root) {
				break;
			}
		}
		
		int j = i;
		for (; j<end; j++) {
			if (array[j] < root)
				return false;
		}
		
		return isPostOrder2(array, start, i-1) && isPostOrder2(array, i, end-1);
		
	}

}
