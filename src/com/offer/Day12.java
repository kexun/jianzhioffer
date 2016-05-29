package com.offer;

public class Day12 {

	public static void main(String[] args) {

		Day12 d = new Day12();
		
//		int[] push = {
//			1,2,3,4,5
//		};
//		
//		int[] pop = {
//				4,3,2,5,1
//		};
//		
//		boolean result = d.isPopOrder(push, pop);
//		System.out.println(result);
		
		BTreeNode head = d.new BTreeNode(0);
		
		BTreeNode node1 = d.new BTreeNode(1);
		BTreeNode node2 = d.new BTreeNode(2);
		BTreeNode node3 = d.new BTreeNode(3);
		BTreeNode node4 = d.new BTreeNode(4);
		BTreeNode node5 = d.new BTreeNode(5);
		BTreeNode node6 = d.new BTreeNode(6);
		BTreeNode node7 = d.new BTreeNode(7);
		
		head.left = node2;
		head.right = node1;
		node1.left = node4;
		node1.right = node6;
		node2.left = node3;
		node2.right = node5;
		node4.left = node7;
		
		d.printTreeInOrder(head);
	}
	
	/**
	 * 判断一个序列是否为 某一个栈的出栈序列 
	 * @param push
	 * @param pop
	 * @return
	 */
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

	
	//////////////////////////////////////////////////////////////////
	
	/**
	 * 二叉树节点
	 * @author kexun
	 *
	 */
	class BTreeNode {
		public int data;
		public BTreeNode left;
		public BTreeNode right;
		public BTreeNode(int data) {
			this.data = data;
		}
	}
	
	/**
	 * 定义一个简单的队列
	 * @author kexun
	 *
	 * @param <T>
	 */
	class Queue<T> {
		
		/**
		 * 队列的头指针
		 */
		public QNode<T> head;
		
		/**
		 * 队列的尾指针
		 */
		public QNode<T> last;
		
		/**
		 * 队列的容器，保存节点数据
		 */
		class QNode<T> {
			public T data;
			public QNode<T> next;
			public QNode(T data) {
				this.data = data;
			}
		}
		
		public Queue() {
			this.head = new QNode<T>(null);
			this.last = new QNode<T>(null);
		}
		
		/**
		 * 尾部插入
		 * @param data
		 */
		public void addLast(T data) {
			
			if (data != null) {
				QNode<T> node = new QNode<T>(data);
				if (head.next == null && last.next == null) {
					head.next = last.next = node; 
				} else {
					QNode<T> tempNode = last.next;
					tempNode.next = node;
					last.next = node;
				}
			}
		}
		
		/**
		 * 头部弹出
		 * @return
		 */
		public T pop() {
			if (head.next != null) {
				QNode<T> node = head.next;
				head.next = node.next;
				if (head.next == null)
					last.next = head.next;
				return node.data;
			}
			return null;
		}
		
	}
	
	/**
	 *  输入树的第一个节点 将一个树从头至尾，从左往右，一层一层打印
	 * @param node
	 */
	public void printTreeInOrder(BTreeNode head) {

		//维护树节点打印的 辅助队列
		Queue<BTreeNode> queue = new Queue<BTreeNode>();
		queue.addLast(head);
		
		BTreeNode currNode = queue.pop();
		while (currNode != null) {
			System.out.println(currNode.data);
			if (currNode.left != null)
				queue.addLast(currNode.left);
			
			if (currNode.right != null)
				queue.addLast(currNode.right);
			
			currNode = queue.pop();
		}
	
	}
	
	
}
