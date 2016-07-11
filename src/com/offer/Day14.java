package com.offer;


/**
 * 非常简单的实现LRU算法   类似LinkedHashMap的功能，但是不实现hashmap，只维护一个双向链表，
 * 仅仅是为了验证LRU而已,这里并未考虑高并发的情况
 * @author kexun
 *
 */
public class Day14 {

	public static void main(String[] args) {
		
		Day14 d = new Day14();
		
		LRUList lru = d.new LRUList(5);
		lru.add("1", 1);
		lru.add("2", 2);
		lru.add("3", 3);
		lru.add("4", 4);
		lru.add("5", 5);
		lru.printList();
		System.out.println("////////////////////");
		lru.add("6", 6);
		lru.add("7", 7);
		lru.printList();
		System.out.println("////////////////////");
		lru.get("123");
		lru.printList();
		System.out.println("////////////////////");
		lru.get("4");
		lru.printList();
		System.out.println("////////////////////");
		lru.add("3", "666");
		lru.printList();
		System.out.println("////////////////////");
		lru.remove("5555");
		lru.printList();
		System.out.println("////////////////////");
		lru.remove("3");
		lru.remove("4");
		lru.remove("7");
		lru.remove("6");
		lru.remove("5");
		lru.remove("1");
		lru.remove("2");
		lru.printList();
		System.out.println("////////////////////");
		lru.add("2", 2);
		lru.add("3", 3);
		lru.add("4", 4);
		lru.printList();
		System.out.println("////////////////////");
		lru.add("45", 45);
		lru.add("46", 46);
		lru.add("67", 67);
		lru.printList();
	}
	
	/**
	 * 实现lru 双向链表 其实内部实现的就是一个收尾想接的循环链表
	 * @author kexun
	 *
	 */
	class LRUList {
		
		/**
		 * 链表大小
		 */
		private int size;
		
		/**
		 * 链表的容量
		 */
		private int capability;
		
		/**
		 * 头指针， before指向链表的头部， after指向链表的尾部
		 */
		public Entry header;
		
		
		public LRUList(int capability) {
			this.capability = capability;
			header = new Entry(null, null);
			header.before = header.after = header;
		}
		
		/**
		 * 添加k-v 如果添加的key存在 则替换value，并且从新调整位置
		 * 如果添加的key不存在，则在头部新增元素
		 * @param key
		 * @param value
		 */
		public void add(String key, Object value) {
			
			Entry entry = getEntry(key);
			if (entry != null) {
				entry.value = value;
			} else {
				if (isFull()) {
					Entry lastEntry = header.after;
					lastEntry.remove();
					size--;
				}
				entry = new Entry(key, value);
				entry.addBefore(header);
				size++;
			}
		}
		
		/**
		 * 获取值
		 * @param key不能为null
		 * @return
		 */
		public Object get(String key) {
			
			Entry entry = getEntry(key);
			if (entry != null)
				return entry.value;
			
			return null;
		}
		
		/**
		 * 获取值
		 * @param key不能为null
		 * @return
		 */
		private Entry getEntry(String key) {
			
			if (key == null)
				return null;
			
			Entry node = header.before;
			while (node != header) {
				if (key.equals(node.key)) {
					node.recordAccess(this);
					return node;
				}
				node = node.before;
			}
			return null;
		}
		
		/**
		 * 移除一个元素
		 * @param key
		 * @return
		 */
		public Object remove(String key) {
			
			Entry entry = removeEntry(key);
			if (entry != null)
				return entry.value;
			
			return null;
		}
		
		/**
		 * 移除一个元素
		 * @param key
		 * @return
		 */
		private Entry removeEntry(String key) {
			
			if (key == null)
				return null;
			
			Entry entry = header.before;
			while (entry != header) {
				if (key.equals(entry.key)) {
					entry.remove();
					size--;
					return entry;
				}
				entry = entry.before;
			}
			
			return null;
		}
		
		/**
		 * 链表大小
		 * @return
		 */
		public int size() {
			return size;
		}
		
		/**
		 * 判断链表元素是否已满
		 * @return
		 */
		public boolean isFull() {
			return size() >= capability;
		}
		
		/**
		 * 从头到尾打印整个链表
		 */
		public void printList() {
			Entry node = header.before;
			while (node != header) {
				System.out.println("key:"+node.key+"  value:"+node.value);
				node = node.before;
			}
		}
		
		/**
		 * lru链表中的元素类型，保存key-value方式，key不可以重复，也不能为null
		 * @author kexun
		 *
		 */
		class Entry {
			
			/**
			 * 双向链表的前后指针
			 */
			Entry before, after;
			
			/**
			 * 原始的k值
			 */
			String key;
			
			/**
			 * 原始的value
			 */
			Object value;
			
			public Entry(String key, Object value) {
				this.key = key;
				this.value = value;
			}
			
			/**
			 * 把当前元素插入到某个元素前
			 * @param entry
			 */
			private void addBefore(Entry entry) {
				after = entry;
				before = entry.before;
				before.after = this;
				after.before = this;
			}
			
			/**
			 * 移除当前元素
			 */
			private void remove() {
				after.before = before;
				before.after = after;
			}
			
			/**
			 * 从新排列当前元素，把当前元素移至头部
			 */
			public void recordAccess(LRUList list) {
				remove();
				addBefore(list.header);
			}
			
			
		}
		
	}
	
	

}
