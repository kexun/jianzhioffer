package com.offer;

/**
 * 二叉搜索熟转换成双向链表    用中序遍历的方式，刚好满足从小到大的排序特点。
 * @author kexun
 *
 */
public class Day17 {

	public static void main(String[] args) {
		
		Day17 d = new Day17();
		
		Node header = d.new Node(10);
		Node node1 = d.new Node(6);
		Node node2 = d.new Node(4);
		Node node3 = d.new Node(8);
		Node node4 = d.new Node(14);
		Node node5 = d.new Node(12);
		Node node6 = d.new Node(16);
		
		header.left = node1;
		header.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.left = node5;
		node4.right = node6;
		
		Node list = d.convert(header);
		d.printList(list);
		
		
	}
	
	/**
	 * 二叉树节点
	 * @author kexun
	 *
	 */
	class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	
	public Node convert(Node node) {
		
		Node tail = tree2List(node);
		
		while (tail.left != null) {
			tail = tail.left;
		}
		
		return tail;
	}

	/**
	 * 通过递归调用， 中序遍历搜素二叉树的方式，把二叉树转变成排序的双向链表
	 * @param node
	 * @return
	 */
	public Node tree2List(Node node) {
		
		if (node == null)
			return null;
		
		if (node.left != null) {
			Node left = tree2List(node.left);
			node.left = left;
			left.right = node;
		}
		
		if (node.right != null) {
			Node right = tree2List(node.right);
			node.right = right;
			right.left = node;
			return right;
		}
		
		return node;
	}
	
	/**
	 * 从头打印双向链表
	 * @param node
	 */
	public void printList(Node node) {
		
		while (node != null) {
			System.out.print(node.data+",");
			node = node.right ;
		}
	}

}
