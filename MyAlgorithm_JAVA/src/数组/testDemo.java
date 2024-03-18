package 数组;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;

/**
 * 双向链表：哈希表 + 双向链表
 */
public class testDemo {


	// node定义
	public class Node {
		int key;
		int val;
		Node prev;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	// 双向链表定义
	public class DoubleList {
		Node head;
		Node tail;
		int size;
		public DoubleList(int size) {
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		/**
		 * 表头为久未使用元素，尾部为最近使用元素
		 * 双向链表的几个方法：
		 * 
		 */
		/// 添加到表尾
		/**
		 * node1 -> x -> tail
		 * node1 <- x <- tail
		 */
		public void addLast(Node x) {
			x.prev = tail.prev;
			x.next = tail;
			tail.prev.next = x;
			tail.prev = x;
			size++;
		}
		
		/// 删除表头元素
		public Node removeFirst() {
			if (head.next == null) {
				return null;
			}
			Node first = head.next;
			remove(first);
			return first;
		}
		
		/// 删除指定元素
		/**
		 * node1 -> x -> node2
		 * node1 <- x <- node2
		 */
		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}
		
		/// 链表大小
		public int size() {
			return size;
		}
	}
	
	HashMap<Integer, Node> map;
	DoubleList cache;
	int cap;
	public testDemo(int cap) {
		map = new HashMap<>();
		cache = new DoubleList(cap);
	}
	/**
	 * 几个主要的方法：
	 * makeRecently: 设置为最近使用元素
	 * addRecently: 添加到表尾
	 * deleteKey: 删除某个key对应的
	 * deleteLeastRecently: 删除队尾元素
	 */
	
	public void makeRecently(int key) {
		Node x = map.get(key);
		cache.remove(x);
		cache.addLast(x);
	}
	
	public void addRecently(int key, int val) {
		Node x = new Node(key, val);
		cache.addLast(x);
		map.put(key, x);
	}
	
	public void deleteKey(int key) {
		if (map.containsKey(key)) {
			return;
		}
		Node x = map.get(key);
		cache.remove(x);
		map.remove(key);
	}
	
	public void deleteLeastRecently(int key, int val) {
		Node x = new Node(key, val);
		Node first = cache.removeFirst();
		map.remove(first.key);
	}
	
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		makeRecently(key);
		return map.get(key).val;
		
	}
	
	public void put(int key, int val) {
		Node x = new Node(key, val);
		if (map.containsKey(key)) {
			deleteKey(key);
			addRecently(key, val);
			return;
		}
		if (cap == cache.size) {
			deleteLeastRecently(key, val);
		}
		addRecently(key, val);
	}
}
