package com.offer;


/**
 * 二叉树中和为某一值的路径  这里的实现方式和原书中有点不一样，但思想一样
 * @author kexun
 *
 */
public class Day15 {

	public static void main(String[] args) {
		
		Day15 d = new Day15();
		TreeNode header = d.new TreeNode(10);
		TreeNode node1 = d.new TreeNode(5);
		TreeNode node2 = d.new TreeNode(12);
		TreeNode node3 = d.new TreeNode(3);
		TreeNode node4 = d.new TreeNode(7);
		TreeNode node5 = d.new TreeNode(4);
		
		header.addLeft(node1);
		header.addRigth(node2);
		node1.addLeft(node3);
		node1.addRigth(node4);
		node3.addLeft(node5);
		
		
		Stack<TreeNode> stack = d.new Stack<TreeNode>();
		
		d.printPath(stack, header, 22);
		

	}

	/**
	 * 利用递归方式  先序遍历数，并把遍历到的节点放入栈，当遍历到节点的时候，如果值相等，则打印路径，如果不相等则不打印。
	 * 当一条路径遍历结束以后，对最新的节点做出栈操作，然后开始遍历有节点。
	 * @param stack
	 * @param tree
	 * @param value
	 */
	public void printPath(Stack<TreeNode> stack, TreeNode tree, int value) {
		
		if (tree == null) {
			return;
		}
		
		stack.push(tree);
		stack.add(tree.data);
		
		printPath(stack, tree.left, value);
		printPath(stack, tree.rigth, value);
		
		if (stack.total == value) {
			printList(stack.header.next);
			System.out.println();
		}
		
		TreeNode node = stack.pop();
		stack.devide(node.data);
		
	}
	
	/**
	 * 从根节点开始到叶子节点打印
	 * @param stack
	 */
	public void printList(Node<TreeNode> node) {

		if (node == null)
			return;
		
		printList(node.next);
		System.out.print(node.data.data+",");
	}
	
	/**
	 * 构造一个颗二叉树节点
	 * @author kexun
	 *
	 */
	class TreeNode {
		public int data;
		public TreeNode left;
		public TreeNode rigth;
		public TreeNode(int data) {
			this.data = data;
		}
		
		public void addLeft(TreeNode node) {
			this.left = node;
		}
		
		public void addRigth(TreeNode node) {
			this.rigth = node;
		}
	}
	
	/**
	 * 栈的节点
	 * @author kexun
	 *
	 * @param <T>
	 */
	class Node<T> {
		public T data;
		public Node<T> next;
		public Node(T data) {
			this.data = data;
		}
	}
	
	/**
	 * 辅助栈
	 * @author kexun
	 *
	 * @param <T>
	 */
	class Stack<T> {
		
		public Node<T> header;
		
		public int total = 0;
		
		public void add(int value) {
			this.total += value;
		}
		
		public void devide(int value) {
			this.total -= value;
		}
		
		public Stack() {
			this.header = new Node<T>(null);
		}
		
		public void push(T data) {
			Node<T> node = new Node<T>(data);
			node.next = header.next;
			header.next = node;
		}
		
		public T pop() {
			if (header.next != null) {
				Node<T> node = header.next;
				header.next = node.next;
				return node.data;
			}
			
			return null;
		}
		
	}
}
