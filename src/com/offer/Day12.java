package com.offer;

public class Day12 {

	public static void main(String[] args) {

		int[] push = {
			1,2,3,4,5
		};
		
		int[] pop = {
				4,3,2,5,1
		};
		
		Day12 d = new Day12();
		boolean result = d.isPopOrder(push, pop);
		System.out.println(result);
		
	}
	
	public boolean isPopOrder(int[] push, int[] pop) {
		
		if (push.length == 0 || pop.length == 0 || push.length != pop.length)
			return false;
		
		Node head = new Node(0);
		
		int popIndex = 0;
		
		for (int p : push) {
			
			while (head.next != null) {
				Node node = head.next;
				if (node.data == pop[popIndex]) {
					popIndex++;
					head.next = node.next;
				} else {
					break;
				}
			}
			
			if (p != pop[popIndex]) {
				Node node = new Node(p);
				node.next = head.next;
				head.next = node;
			} else {
				popIndex++;
			}
		}
		
		Node node = head.next;
		
		while (node != null) {
			if (node.data != pop[popIndex]) {
				return false;
			} else {
				popIndex++;
				node = node.next;
			}
		}
		
		return true;
	}
	
	class Node{
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
