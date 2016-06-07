package com.offer;

/**
 * 两个链表的公共节点，因为这个是单向链表，从公共节点开始，后面的链表肯定是重复的。
 * 这里有两个方法，第一种可以从尾部开始把节点入栈，然后对栈进行遍历，找到共同点。
 * 第二种方法，判断两个链表的长度，找出多余的部分，然后从共同长度的节点开始遍历
 * @author kexun
 *
 */
public class Day25 {

	public static void main(String[] args) {
		Day25 da = new Day25();
		
		Node first = da.new Node(1);
		Node second = da.new Node(8);
		
		Node a = da.new Node(1);
		Node b = da.new Node(2);
		Node c = da.new Node(3);
		Node d = da.new Node(4);
		Node e = da.new Node(5);
		Node f = da.new Node(6);
		Node g = da.new Node(7);
		Node h = da.new Node(8);
		Node i = da.new Node(9);
		Node j = da.new Node(10);
		
		first.next = a;
		a.next = b;
		b.next = g;
		
		second.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;

		da.findCommonNode(first, second);
	}
	
	public void findCommonNode(Node first, Node second) {
		
		int lengthFirst = 0;
		int lengthSec = 0;
		
		Node fNode = first.next;
		while (fNode != null) {
			fNode = fNode.next;
			lengthFirst++;
		}
		
		Node sNode = second.next;
		while (sNode != null) {
			sNode = sNode.next;
			lengthSec++;
		}
		
		if (lengthFirst >= lengthSec) {
			int len = lengthFirst - lengthSec;
			for (int i = 0; i < len; i++) {
				first = first.next;
			}
			
		} else {
			int len = lengthSec - lengthFirst;
			for (int i = 0; i < len; i++) {
				second = second.next;
			}
		}
		
		
		while (first != second) {
			first = first.next;
			second = second.next;
		}
		
		System.out.println(first.data);
		System.out.println(second.data);
	
	}
	
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
