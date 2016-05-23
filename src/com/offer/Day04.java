package com.offer;

import java.util.LinkedList;

/**
 * 两个栈实现队列效果   两个队列实现栈的效果
 * @author kexun
 *
 */
public class Day04 {

	
	public static void main(String[] args) {

		Queue<Integer> queue = new Day04().new Queue<Integer>();
		Queue<Integer> queue2 = new Day04().new Queue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue2.push(55);
		queue2.push(66);
		queue2.push(77);
		
		while (queue2.hasNext()) {
			System.out.println(queue2.poll());
		}
		while (queue.hasNext()) {
			System.out.println(queue.poll());
		}
		
		
	}
	
	static class Main {
		public static void main(String[] args) {
			Day04 d = new Day04();

			Stack<Integer> stack = d.new Stack<>();
			stack.addFirst(1);
			stack.addFirst(2);
			stack.addFirst(3);
			stack.addFirst(4);
			
			while (stack.hasNext()) {
				System.out.println(stack.pop());
			}
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}
	}
	

	/**
	 * 队列的实现
	 * @author kexun
	 *
	 * @param <T>
	 */
	public class Queue<T> {
		private LinkedList<T> first = new LinkedList<>();
		private LinkedList<T> second = new LinkedList<>();
		
		/**
		 * 插入对了
		 * @param t
		 */
		public void push(T t) {
			first.addFirst(t);
		}
		
		/**
		 * 返回并移除队头
		 * @return
		 */
		public T poll() {
			
			if (first.isEmpty() && second.isEmpty()) {
				return null;
			}
			
			if (second.isEmpty()) {
				while (!first.isEmpty()) {
					second.addFirst(first.pollFirst());
				}
			}
			
			return second.pollFirst();
		}
		
		public boolean hasNext() {
			if (first.isEmpty() && second.isEmpty())
				return false;
			return true;
		}
		
	}
	
	/**
	 * 两个队列实现栈	
	 * @author kexun
	 *
	 * @param <T>
	 */
	public class Stack<T> {
		private java.util.Queue<T> first = new LinkedList<T>();
		private java.util.Queue<T> second = new LinkedList<T>();
		
		/**
		 * 入栈
		 * @param t
		 */
		public void addFirst(T t) {
			first.offer(t);
		}
		
		/**
		 * 出栈
		 * @return
		 */
		public T pop() {
			if (second.isEmpty()) {
				while (!first.isEmpty()) {
					if (first.size() == 1) {
						return first.poll();
					}
					second.offer(first.poll());
				}
			}
			
			if (first.isEmpty()) {
				while (!second.isEmpty()) {
					if (second.size() == 1) {
						return second.poll();
					}
					first.offer(second.poll());
				}
			}
			
			return null;
		}
		
		public boolean hasNext() {
			if (first.isEmpty() && second.isEmpty())
				return false;
			return true;
		}
	}
	

}
