package com.offer;

public class Day10 {

	
	public static void main(String[] args) {
		
		Day10 d = new Day10();
		
//		Tree head = d.new Tree(0);
//		Tree node1 = d.new Tree(1);
//		Tree node2 = d.new Tree(2);
//		Tree node3 = d.new Tree(3);
//		Tree node4 = d.new Tree(4);
//		Tree node5 = d.new Tree(5);
//		Tree node6 = d.new Tree(6);
//		Tree node7 = d.new Tree(7);
//		Tree node8 = d.new Tree(8);
//		Tree node9 = d.new Tree(9);
//		Tree node10 = d.new Tree(10);
//		Tree node11 = d.new Tree(11);
//		Tree node12 = d.new Tree(12);
//		Tree node13 = d.new Tree(13);
//		
//		head.left = node1;
//		head.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		node2.left = node5;
//		node2.right = node6;
//		node3.left = node7;
//		node3.right = node8;
//		node4.left = node9;
//		node4.right = node10;
//		node5.left = node11;
//		node5.right = node12;
//		node6.left = node13;
//		
//		d.printTree(head);
//		
//		d.mirrorRecursive(head);
//		System.out.println("-----------");
//		d.printTree(head);
		
		int[][] array = {
				{
					1,2,3,4,7,3
				},
				{
					1,2,3,4,10,23
				},
				{
					1,2,3,4,23,43
				},
				{
					1,2,3,4,23,43
				},
				{
					1,2,3,4,23,43
				},
				{
					1,2,3,4,23,43
				},
				{
					1,2,3,4,23,43
				},
				{
					1,2,3,4,9,56
				}
		};
		

		d.printMatrixClockwisely(array, 1);
	}
	
	
	/**
	 * 将二叉树镜像旋转
	 * @param node
	 */
	public void mirrorRecursive(Tree node) {
		
		if (node == null)
			return;
		
		Tree temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		if (node.left != null) {
			mirrorRecursive(node.left);
		} 
		
		if (node.right != null) {
			mirrorRecursive(node.right);
		}
	}
	
	
	public void printTree(Tree head) {
		
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		printTree(head.left);
		printTree(head.right);
	}
	
	class Tree {
		public int data;
		public Tree left;
		public Tree right;
		
		public Tree(int data) {
			this.data = data;
		}
	}
	
	
	////////////////////////////////////////////////
	
	
	/**
	 * 顺时针打印数组
	 * @param array
	 * @param start
	 */
	public void printMatrixClockwisely(int[][] array, int start) {
		
		if (array.length == 0 || start <= 0)
			return;
		
		int row = 0;
		int xlength = array.length;
		int ylength = array[0].length;
		
		if (array.length >= array[0].length) {
			int temp = array[0].length % 2;
			row = array[0].length / 2 + temp;
		} else {
			int temp = array.length % 2;
			row = array.length / 2 + temp;
		}
		
		if (start > row)
			return;
		
		// 从左向右打印一行，到行尾以后从上往下打印一列
		for (int y = start-1; y <= ylength - start; y++) {
			int value = array[start-1][y];
			System.out.println(value);
		}
		
		// 从上往下打印
		for (int x = start; x <= xlength - start; x++) {
			int value = array[x][ylength-start];
			System.out.println(value);
		}
		
		// 从右往左打印
		for (int y = ylength - start -1; y >= start-1; y--) {
			int value = array[xlength-start][y];
			System.out.println(value);
		}
	
		// 从下往上打印
		for (int x = xlength-start-1; x >= start; x--) {
			int value = array[x][start-1];
			System.out.println(value);
		}
		
		start++;
		
		printMatrixClockwisely(array, start);
	}
	
	
}











