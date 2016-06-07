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
		
		MyInt depth = d.new MyInt(0);
		boolean isBalance = d.isBalance(head, depth);
		System.out.println(isBalance);
		System.out.println(depth.data);
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
	
	/**
	 * 判断是否是平衡二叉树，定义是：左右子树的深度差不超过1
	 * @param tree
	 * @param depth
	 * @return
	 */
	public boolean isBalance(Node tree, MyInt depth) {

		if (tree == null) {
			depth.data = 0;
			return true;
		}
		
		MyInt left = new MyInt(0);
		MyInt right = new MyInt(0);
		
		if (isBalance(tree.left, left) && isBalance(tree.right, right)) {
			
			Integer diff = left.data - right.data;
			if (diff > 1 || diff < -1)
				return false;
			
			depth.data = left.data>right.data ? left.data+1:right.data+1;
			return true;
		}
		return false;
	}
	
	/**
	 * 这里值得注意的是，java并没有传引用这种方式，因此传入一个int 基本类型的时候，只
	 * 改变他的副本，不改变实参。因此把这个int封装成一个引用类型，引用类型传递的也是副本
	 * 不同的是，他们指向的是同一个对象。
	 * @author kexun
	 *
	 */
	class MyInt{
		public int data;
		public MyInt(int data) {
			this.data = data;
		}
	}

}
