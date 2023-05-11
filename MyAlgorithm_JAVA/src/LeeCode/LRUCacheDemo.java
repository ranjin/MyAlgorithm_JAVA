package LeeCode;

import java.util.HashMap;

public class LRUCacheDemo {

	
	// 哈希表 + 双向链表
	
	// Node节点(包含前后驱)
	public class Node {
		int val;
		int key;
		Node prev;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public class DoubleList {
		int size;
		Node head;
		Node tail;
		public DoubleList() {
			head.next = tail;
			tail.prev = head;
			this.size = 0;
		}
		
		// 链表需要具备的功能：表头为久未使用元素，表尾为最近使用元素
		//1. 表尾添加元素
		// node1 -> x -> tail
		// node1 <- x <- tail
		public void addLast(Node x) {
			x.prev = tail.prev;
			x.next = tail;
			tail.prev.next = x;
			tail.prev = x;
			size++;
		}
		
		// 删除指定节点
		// node1 -> x -> node2
		// node2 <- x <- node1
		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}
		
		// 删除表头节点并返回
		public Node removeFirst() {
			if (head.next == null) {
				return null;
			}
			Node x = head.next;
			remove(x);
			return x;
		}
		
		public int size() {
			return size;
		}
		
		// 同时应该具备的几个方法
		// 1. makeRecently()
	}
	
	public class LRUCacheCode {
		HashMap<Integer, Node> map;
		DoubleList cache;
		int cap;
		public LRUCacheCode(int cap) {
			this.cap = cap;
			map = new HashMap<>();
			cache = new DoubleList();
		}
		// 提升为最近使用元素
		public void makeRecently(int key) {
			Node x = map.get(key);
			
			cache.remove(x);
			cache.addLast(x);
		}
		
		// 
		public void addRecently(int key, int val) {
			Node x = new Node(key, val);
			cache.addLast(x);
			map.put(key, x);
		}
		
		public void deleteKey(int key) {
			Node x = map.get(key);
			
			cache.remove(x);
			map.remove(key);
		}
		
		// 删除久未使用元素
		public void deleteRecently() {
			// 
			Node x = cache.removeFirst();
			map.remove(x.key);
		}
		
		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			makeRecently(key);
			return map.get(key).val;
		}
		
		public void put(int key, int val) {
			if (map.containsKey(key)) {
				// 包含
				deleteKey(key);
				addRecently(key, val);
				return;
			}
			
			// 不包含
			if (cache.size() == cap) {
				deleteRecently();
			}
			addRecently(key, val);
		}
		
	}
	
}
