package com.offer;

import sun.net.www.content.audio.wav;

public class Day09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Day09 d = new Day09();
		Tree root = d.new Tree(0);
		Tree left1 = d.new Tree(1);
		Tree r1 = d.new Tree(2);
		Tree left2 = d.new Tree(3);
		Tree r2 = d.new Tree(4);
		
		Tree root2 = d.new Tree(1);
		Tree l1 = d.new Tree(3);
		Tree rr2 = d.new Tree(4);
		
		root.left = left1;
		root.right = r1;
		left1.left = left2;
		left1.right = r2;
		
		root2.left = l1;
		root2.right = rr2;
		
		boolean result = d.hasSubTree(root, root2);
		System.out.println(result);
		
		

	}
	
	/**
	 * 通过递归的方法  树a是不是树b的子结构
	 * @param root
	 * @param sub
	 * @return
	 */
	public boolean hasSubTree(Tree root, Tree sub) {
		
		boolean result = false;
		
		if (root == null || sub == null) {
			return false;
		}
		
		if (root.data == sub.data) {
			result = true;
		}
		
		if (result) {
			result = dosTreeHasSub(root, sub);
		}
		
		if (!result)
			result = hasSubTree(root.left, sub);
		
		if (!result)
			result = hasSubTree(root.right, sub);
		
		return result;
	}

	public boolean dosTreeHasSub(Tree root, Tree sub) {
		
		if (sub == null)
			return true;
		
		if (root == null)
			return false;
		
		if (root.data != sub.data)
			return false;
		
		return dosTreeHasSub(root.left, sub.left) && dosTreeHasSub(root.right, sub.right);
	}
	
	
	
	
	
	
	
	
	class Tree {
		public int data;
		public Tree left;
		public Tree right;
		
		public Tree(int data) {
			this.data = data;
		}
	}
}
