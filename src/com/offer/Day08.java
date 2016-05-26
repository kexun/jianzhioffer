package com.offer;

public class Day08 {

	public static void main(String[] args) {
		
		Day08 d = new Day08();
//		Node head = d.new Node(0);
//		
//		Node node1 = d.new Node(1);
//		Node node2 = d.new Node(2);
//		Node node3 = d.new Node(3);
//		Node node4 = d.new Node(4);
//		Node node5 = d.new Node(5);
//		Node node6 = d.new Node(6);
//		Node node7 = d.new Node(7);
//		Node node8 = d.new Node(8);
//		Node node9 = d.new Node(9);
//		Node node10 = d.new Node(10);
//		Node node11 = d.new Node(11);
//		Node node12 = d.new Node(12);
//		
//		head.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		node7.next = node8;
//		node8.next = node9;
//		node9.next = node10;
//		node10.next = node11;
//		node11.next = node12;
//		node12.next = null;
		
//		Node n = d.findNodeToTail(head, 12);
//		System.out.println(n.data);
		
//		Node h = d.reverseList(head);
//		d.printList(h);
		
		Node head1 = d.new Node(0);
		Node head2 = d.new Node(0);
		
		Node node1 = d.new Node(1);
		Node node2 = d.new Node(2);
		Node node3 = d.new Node(3);
		Node node4 = d.new Node(4);
		Node node5 = d.new Node(5);
		Node node6 = d.new Node(6);
		Node node7 = d.new Node(7);
		Node node8 = d.new Node(8);
		Node node9 = d.new Node(9);
		Node node10 = d.new Node(10);
		Node node11 = d.new Node(11);
		Node node12 = d.new Node(12);
		
		Node node13 = d.new Node(2);
		Node node14 = d.new Node(3);
		Node node15 = d.new Node(4);
		Node node16 = d.new Node(5);
		Node node17 = d.new Node(6);
		
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		head2.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;
		node17.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = null;
		
		
		Node list = d.mergeSortedList(head1, head2);
		d.printList(list);
		
	}
	
	/**
	 * 打印单向链表的倒数第n个节点
	 * @param head
	 * @param k
	 * @return
	 */
	public Node findNodeToTail(Node head, int k) {
		
		
		if (head == null || head.next == null || k == 0)
			return null;
		
		Node node = head;
		
		for (int i = 1; i < k; i++) {
			node = node.next;
			
			if (node.next == null)
				return null;
		}
		
		Node secondNode = head;
		
		while (node.next != null) {
			node = node.next;
			secondNode = secondNode.next;
		}
		
		return secondNode;
	}
	
	
	class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public Node reverseList(Node head) {
		
		if (head == null || head.next == null)
			return null;
		
		Node preNode = null;
		Node nextNode = null;
		
		Node node = head.next;
		while (node != null) {

			nextNode = node.next;
			if (preNode != null) {
				node.next = preNode;
				preNode = node;
			} else {
				preNode = node;
				preNode.next = null;
			}
			node = nextNode;
		}
		
		return preNode;
		
	}
	
	public void printList(Node head) {
		
		Node node = head;
		
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	/////////////////////////////////////////////
	
	/**
	 * 对两个排序好的链表 合并并且排序
	 * @param first
	 * @param second
	 */
	public Node mergeSortedList(Node first, Node second) {
		
		if (first == null)
			return second;
		
		if (second == null)
			return first;
		
		Node mergedList = null;
		
		if (first.data >= second.data) {
			mergedList = second;
			mergedList.next = mergeSortedList(first, second.next);
		} else {
			mergedList = first;
			mergedList.next = mergeSortedList(first.next, second);
		}
		
		return mergedList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
