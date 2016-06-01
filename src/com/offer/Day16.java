package com.offer;

/**
 * 复杂链表的复制
 * @author kexun
 *
 */
public class Day16 {

	public static void main(String[] args) {

		Day16 d = new Day16();
		Node header = d.new Node(-1);
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
		
		header.next = node1;
		node1.next = node2;
		node1.sibling = node6;
		node2.next = node3;
		node2.sibling = node3;
		node3.next = node4;
		node3.sibling = node8;
		node4.next = node5;
		node4.sibling = node1;
		node5.next = node6;
		node5.sibling = node9;
		node6.next = node7;
		node6.sibling = node4;
		node7.next = node8;
		node7.sibling = node2;
		node8.next = node9;
		node8.sibling = node8;
		node9.next = node10;
		node10.next = node11;
		
		d.cloneList(header);
		d.cloneSibling(header);
		Node clone = d.devide(header);
		d.printList(clone);
		System.out.println("------------");
		d.printList(header);
		
	}
	
	/**
	 * 复杂链表的节点， next 指向下一个节点  
	 * sibling随意指向一个节点，也可以指向null
	 * @author kexun
	 *
	 */
	class Node {
		public int data;
		public Node next;
		public Node sibling;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	/**
	 * 给定一个复制链表，复制每个节点，复制方式如下  A->A1->B->B1->C->C1
	 * @param header
	 */
	public void cloneList(Node header) {
		if (header == null)
			return;
		
		Node node = header.next;
		while (node != null) {
			Node cloneNode = new Node(node.data);
			cloneNode.next = node.next;
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}
	
	/**
	 * 复制每个节点的sibling指针
	 * @param header
	 */
	public void cloneSibling(Node header) {
	
		if (header == null)
			return;
		
		Node node = header.next;
		while (node != null) {
			Node cloneNode = node.next;
			if (node.sibling != null) {
				cloneNode.sibling = node.sibling.next;
			}
			node = cloneNode.next;
		}
	}
	
	/**
	 * 把之前合在一起的链表，拆分成两个链表
	 * @param header
	 * @return
	 */
	public Node devide(Node header) {
		
		if (header == null)
			return null;

		Node node = header.next;
		
		Node cloneHeader = new Node(-1);
		Node cloneNode = null;
		if (node != null) {
			cloneHeader.next = cloneNode = node.next;
			node.next = cloneNode.next;
			node = cloneNode.next;
		}
		
		while (node != null) {
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		
		return cloneHeader;
	}
	
	/**
	 * 打印复制链表
	 * @param header
	 */
	public void printList(Node header) {
		
		if (header == null)
			return;
		
		Node node = header.next;
		
		while (node != null) {
			Node temp = node.sibling;
			if (temp != null) {
				
				System.out.println("data="+node.data+" si="+temp.data);
			} else {
				System.out.println("data="+node.data+" si=null");
			}
			node = node.next;
		}
	}

	
}
