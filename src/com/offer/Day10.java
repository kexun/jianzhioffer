package com.offer;

public class Day10 {

	
	public static void main(String[] args) {
		
		Day10 d = new Day10();
		
		Tree head = d.new Tree(0);
		Tree node1 = d.new Tree(1);
		Tree node2 = d.new Tree(2);
		Tree node3 = d.new Tree(3);
		Tree node4 = d.new Tree(4);
		Tree node5 = d.new Tree(5);
		Tree node6 = d.new Tree(6);
		Tree node7 = d.new Tree(7);
		Tree node8 = d.new Tree(8);
		Tree node9 = d.new Tree(9);
		Tree node10 = d.new Tree(10);
		Tree node11 = d.new Tree(11);
		Tree node12 = d.new Tree(12);
		Tree node13 = d.new Tree(13);
		
		head.left = node1;
		head.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		node4.left = node9;
		node4.right = node10;
		node5.left = node11;
		node5.right = node12;
		node6.left = node13;
		
		d.printTree(head);
		
		d.mirrorRecursive(head);
		System.out.println("-----------");
		d.printTree(head);
		
	}
	
	
	/**
	 * 将二叉树镜像旋转
	 * @param node
	 */
	public void mirrorRecursive(Tree node) {
		
		if (node == null)
			return;
		
		if (node.left != null && node.right != null) {
			Tree temp = node.left;
			node.left = node.right;
			node.right = temp;
			mirrorRecursive(node.left);
			mirrorRecursive(node.right);
		} else if (node.left != null) {
			mirrorRecursive(node.left);
		} else if (node.right != null) {
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
}
