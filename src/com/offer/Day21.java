package com.offer;

/**
 * 最小的k个数字
 * @author kexun
 *
 */
public class Day21 {

	public static void main(String[] args) {
		int[] array = {
			5,7,3,0,8,2,3,8,6,1,4,8,56,3,0,8,9
		};
		
		Day21 d = new Day21();
//		d.method1(array, 3);
		d.method2(array, 7);
	}
	
	/**
	 * 利用快排思想，第k位置的左边都小于他  右边都大于他
	 * @param array
	 */
	public void method1(int[] array, int k) {

		int length = array.length;
		if (length == 0)
			return;

		int start = 0;
		int end = length - 1;
		int position = position(array, start, end);
		
		while (position != k-1) {
			if (position > k - 1) {
				end = position - 1;
				position = position(array, start, end);
			} else {
				start = position + 1;
				position = position(array, start, end);
			}
		}
		
		print(array, position);
	}
	
	/**
	 * 还是之前的做法 快排思想， 返回基准值的位置
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int position(int[] array, int start, int end) {
		
		int base = array[start];
		
		while (start < end) {
			
			// 从右往左找小于基数的值，并互换位置
			while (start < end && array[end] >= base) {
				end--;
			}
			
			if (start < end) {
				array[start] = array[end];
				start++;
			}
			
			// 从左往右找大于基数的值，并互换位置
			while (start < end && array[start] < base) {
				start++;
			}
			
			if (start < end) {
				array[end] = array[start];
				end--;
			}
			
		}
		
		array[start] = base;
		return start;
		
	}
	
	public void print(int[] array, int k) {
		int length = array.length;
		if (k > length-1)
			return;
		
		for (int i=0; i<=k; i++) {
			System.out.print(array[i]+",");
		}
	}
	
	///////////////////////////方法二//////////////////////////////////////
	
	/**
	 * 这个时间复杂度比第一种慢，但是比较时候大数据的情况下使用。
	 * 具体做法是遍历数组，把每个元素的值和大根堆比较，当值小于大根堆的最大值，
	 * 就放如堆中。最后得到的堆就是数组前k个小的值
	 * @param array
	 * @param k
	 */
	public void method2(int[] array, int k) {

		int length = array.length;
		if (length == 0 || k > length) {
			return;
		}
		
		Heap heap = new Heap(k);
		
		for (int a : array) {
			heap.add(a);
		}
		
		heap.print();
	}
	
	/**
	 * 简单实现一个大根堆，辅助排序。
	 * 遍历数组的时候，把最小的前k个数放入堆中。
	 * @author kexun
	 *
	 */
	static class Heap {
		
		/**
		 * 节点
		 * @author kexun
		 *
		 */
		
		int size = 0;
		int capacity;
		
		int[] array;
		
		public Heap(int capacity) {
			this.capacity = capacity;
			array = new int[capacity];
		}
		
		public int size() {
			return size;
		}
		
		public void size(int size) {
			this.size = size;
		}
		
		public boolean isFull() {
			return size >= capacity;
		}
		
		/**
		 * 增加一个元素
		 * @param data
		 */
		public void add(int data) {
			
			if (isFull()) {
				// 当堆满的时候，插入小于最大根的值，并把最大跟删除，然后从新调整堆
				if (data < array[0]) {
					array[0] = data;
					heapSort();
				}
			} else {
				// 堆未满的时候，直接插入值,并调整堆顺序
				array[size] = data;
				size++;
				heapSort();
			}
		}
		
		public void print() {
			for (int a : array) {
				System.out.print(a + ",");
			}
		}
		
//		public static void main(String[] args) {
//			Heap h = new Heap(8);
//			h.size(8);
//			h.heapSort();
//			h.print();
//			
//		}
		
		/**
		 * 堆排序
		 */
		public void heapSort() {

			for (int i = size / 2; i >= 0; i--) {
				heapAdjust(array, i, size - 1);
			}

		}
		
		public void heapAdjust(int[] arr, int s, int m) {

			int temp, j;
			temp = arr[s]; 

			// 这里需要解释一下， 第一步把当前根节点排序，排完以后，对调以后的一棵树需要重新排序。
			for (j = 2 * s+1; j <= m; j = j*2+1) {

				if (j < m && arr[j] < arr[j + 1]) {
					j++;
				}

				if (temp >= arr[j]) {
					break;
				}

				arr[s] = arr[j];
				s = j;
			}

			arr[s] = temp;
		}
		
	}

}
