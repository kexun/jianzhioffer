package com.offer;

/**
 * 二叉树深度
 * @author kexun
 *
 */
public class Day27 {

	public static void main(String[] args) {
		
		Day27 d = new Day27();
		
		Node head = d.new Node(0);
		Node node1 = d.new Node(0);
		Node node2 = d.new Node(0);
		Node node3 = d.new Node(0);
		Node node4 = d.new Node(0);
		Node node5 = d.new Node(0);
		Node node6 = d.new Node(0);
		Node node7 = d.new Node(0);
		Node node8 = d.new Node(0);
		Node node9 = d.new Node(0);
		Node node10 = d.new Node(0);
		Node node11 = d.new Node(0);
		
		head.left = node1;
		head.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node5.left = node6;
		node5.right = node7;
		node7.right = node8;
		node8.right = node9;
		node9.left = node10;
		node10.left = node11;
		
		int dep = d.treeDepth(head);
		System.out.println(dep);
	}
	
	/**
	 * 递归遍历树，把每个节点的深度相加，判断左右节点，返回深度大的值。
	 * @param tree
	 * @return
	 */
	public int treeDepth(Node tree) {
		
		if (tree == null) {
			return 0;
		}
		
		int left = treeDepth(tree.left) + 1;
		int right = treeDepth(tree.right) + 1;
		
		return left > right ? left : right;
	}
	
	class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
