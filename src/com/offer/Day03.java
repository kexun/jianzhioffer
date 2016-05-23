package com.offer;

/**
 * 给定一个前序，中序，重建二叉树，假设节点中，没有重复的值。
 * @author kexun
 *
 */
public class Day03 {


	public int[] first =  {1,2,4,7,3,5,6,8};
	public int[] middle = {4,7,2,1,5,3,8,6};
	
	private int rootIndex = 0;
	public Node constructTree(int ifirst, int iend) {
		
		if (rootIndex < 0 || rootIndex >= first.length) {
			return null;
		}
		
		int rootValue = first[rootIndex];
		Node rootNode = new Node(rootValue);
		
		int mindex = 0;
		for (int i = ifirst; i<=iend; i++) {
			if (rootValue == middle[i]) {
				mindex = i;
				break;
			}
		}
		
		rootIndex++;
		if (mindex - ifirst > 0) {
			rootNode.left = constructTree(ifirst, mindex - 1);
		}
		
		if (iend - mindex > 0) {
			rootNode.right = constructTree(mindex + 1, iend);
		}
		
		return rootNode;
	}
	

	public void printPreOrder(Node head) {
		

		if (head != null) {
			System.out.println(head.value);
			
			printPreOrder(head.left);
			printPreOrder(head.right);
		}
	}
	
	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		
		Day03 d3 = new Day03();
		Day03.Node head = d3.constructTree(0, d3.middle.length-1);
		d3.printPreOrder(head);
		
	}
	
}
