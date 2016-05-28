package com.offer;

public class Day11 {

	
	public MyStack stack;
	
	public static void main(String[] args) {

		Day11 d = new Day11();
		
		d.stack.push(3);
		d.stack.push(4);
		d.stack.push(37);
		d.stack.push(10);
		d.stack.push(13);
		d.stack.push(32);
		d.stack.push(67);
		d.stack.push(2);
		d.stack.push(9);
		d.stack.push(45);
		
		System.out.println(d.stack.getMin().data);
		
	}
	
	public Day11() {
		this.stack = new MyStack();
	}
	
	/**
	 * 自定义栈， 能在O(1)  时间内执行 push pop  获取最小值的操作
	 * @author kexun
	 *
	 */
	class MyStack {
		
		private Node head;
		private Node sortedHead;
		
		
		public MyStack() {
			this.head = new Node(0);
			this.sortedHead = new Node(0);
		}
		
		/**
		 * 正常入栈  但是要维护一个排序的栈
		 * @param data
		 */
		public void push(int data) {
			Node node = new Node(data);
			node.next = head.next;
			this.head.next = node;
			
			pushSortedList(data);
		}
		
		/**
		 * 正常出栈
		 * @return
		 */
		public Node pop() {
			
			if (head.next == null) {
				return null;
			}
			
			Node value = head.next;
			head.next = value.next;
			
			popSortedList(value);
			
			return value;
		}
		
		/**
		 * 入栈 并排序
		 * @param data
		 */
		public void pushSortedList(int data) {
			
			Node first = sortedHead.next;
			
			if (first  == null) {
				Node node = new Node(data);
				sortedHead.next = node;
				return;
			}
			
			if (data < first.data) {
				Node node = new Node(data);
				node.next = first;
				sortedHead.next = node;
			} else {
				Node node = new Node(first.data);
				node.next = first;
				sortedHead.next = node;
			}
		}
		
		/**
		 * 如果当前出栈的节点等于当前最小节点 则出栈
		 * @param node
		 */
		public void popSortedList(Node node) {
			
			if (node == null || sortedHead.next == null)
				return;
			
			Node first = sortedHead.next;
			
			if (node.data == first.data) {
				sortedHead.next = first.next;
			}
			
		}
		
		/**
		 * 获取当前栈的最小节点
		 * @return
		 */
		public Node getMin() {
			return sortedHead.next;
		}
		
	}
	
	class Node {
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
		}
	}

}
