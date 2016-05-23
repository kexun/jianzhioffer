package com.offer;

/**
 * 在不改变原来数据结构的前提下，将一个链表从尾到头打印。
 * 利用递归的方式。
 * @author kexun
 *
 */
public class Day02 {

	public static void main(String[] vag) {
		Node first = new Node(1);
		first.next(new Node(2)).next(new Node(3)).next(new Node(4)).next(new Node(5));
		revert(first);
	}
	
	/**
	 * 递归调用
	 * @param node
	 */
	private static void revert(Node node) {
		
		if (node != null) {
			revert(node.next);
			System.out.println(node.value);
		}
	}
	
	private static class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node next(Node node) {
			return this.next = node;
		}
	}
}
