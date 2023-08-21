package 数组;

import java.util.HashMap;

public class testDemo {

	public class Node {
		int key;
		int val;
		Node pre;
		Node next;
		public Node(int val, int key) {
			this.val = val;
			this.key = key;
		}
	}
	
	public class DoubleList {
		Node head;
		Node tail;
		int size;
		public DoubleList() {
			size = 0;
			head = new Node(0, 0);
			tail = new Node(0, 0);
			head.next = tail;
			tail.pre = head;
		}
		/**
		 * 左边表头，右边表尾
		 * 表头为久未使用元素，表尾为最近使用元素
		 * 需要的几个方法
		 * 1. addLast: 添加表尾元素
		 * 2. removeNode: 删除指定元素
		 * 3. removeFirst: 删除表头元素
		 * 4. size: 返回链表size
		 */
		// node1 -> x -> tail
		// node1 <- x <- tail
		public void addLast(Node x) {
			x.pre = tail.pre;
			x.next = tail;
			
			tail.pre.next = x;
			tail.pre = x;
			size++;
		}
		
		// node1 -> x -> node2
		// node1 <- x <- node2
		public void remove(Node x) {
			x.pre.next = x.next;
			x.next.pre = x.pre;
			size--;
		}
		
		public Node removeFirst() {
			if (head.next == null) {
				return head;
			}
			
			Node x = head.next;
			remove(x);
			return x;
		}
		
		public int size() {
			return size;
		}
	}
	
	public class LRUCache {
	    private	int cap;
		private HashMap<Integer, Node> map;
		private DoubleList cache;
		public LRUCache(int cap) {	
			this.cap = cap;
			map = new HashMap<>();
			cache = new DoubleList();
		}
		/**
		 * 几个方法
		 * makeRecently: 删除节点，且放在表尾，作为最近使用元素
		 * addRecently: 表尾添加元素
		 * deleteKey: 两个容器删除
		 * removeLastRecently: 删除久未使用元素
		 */
		public void makeRecently(int key) {
			if (!map.containsKey(key)) {
				return;
			}
			Node x = map.get(key);
			cache.remove(x);
			cache.addLast(x);
		}
		
		public void addRecently(int key, int val) {
			Node x = new Node(val, key);
			cache.addLast(x);
			map.put(key, x);
		}
		
		public void deleteKey(int key) {
			if (!map.containsKey(key)) {
				return;
			}
			Node x = map.get(key);
			cache.remove(x);
			map.remove(key);
		}
		
		public void removeLastRecently() {
			Node x = cache.removeFirst();
			
			map.remove(x.key);
		}
		
		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			Node x = map.get(key);
			makeRecently(key);
			return map.get(key).val;
		}
		
		public void put(int key, int val) {
			if (map.containsKey(key)) {
				deleteKey(key);
				addRecently(key, val);
				return;
			}
			if (cap == cache.size) {
				removeLastRecently();
			}
			addRecently(key, val);
		}
	}
}
