package LeeCode;
import java.util.HashMap;

/**
 * 哈希表 + 双向链表
 * 
 *
 */
public class LRUCacheDemo {
	public class ListNode {
		ListNode next;
		ListNode prev;
		int val;
		int key;
		public ListNode(int val, int key) {
			this.key = key;
			this.val = val;
		}
	}
	
	// 双向链表，头部为久未使用元素，尾部为最新元素
	public class DoubleList {
		ListNode head;
		ListNode tail;
		int size;
		public DoubleList() {
			head = new ListNode(0, 0);
			tail = new ListNode(0, 0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		// 尾部添加元素
		// node1 -> node2
		// node1 -> x -> node2
		// node1 <- x <- node2
		public void addLast(ListNode node) {
			node.prev = tail.prev;
			node.next = tail;
			node.prev.next = node;
			tail.prev = node;
			size++;
		}
		
		// 删除某个元素
		public void deleteNode(ListNode node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
		}
		
		// 删除头部元素并返回
		public ListNode deleteFirst() {
			if (head.next == tail) {
				return null;
			}
			ListNode node = head.next;
			deleteNode(node);
			return node;
		}
		
		// 返回链表size
		public int size() {
			return this.size;
		}
	}
	
	public class LRUCache {
		DoubleList cache;
		HashMap<Integer, ListNode> map;
		
		// 容量
		private int cap;
		public LRUCache(int capacity) {
			this.cap = capacity;
			cache = new DoubleList();
			map = new HashMap<>();
		}
		
		// 将元素置为最近使用元素
		public void makeRecently(int key) {
			ListNode node = map.get(key);
			cache.deleteNode(node);
			cache.addLast(node);
		}
		
		// 删除久未使用元素
		public void removeLeastRecently() {
			ListNode node = cache.deleteFirst();
			map.remove(node.key);
		}
		
		// 添加最近使用元素
		public void addRecently(int key, int val) {
			ListNode x = new ListNode(key, val);
			cache.addLast(x);
			map.put(key, x);
		}
		
		public void deleteKey(int key) {
			ListNode x = map.get(key);
			cache.deleteNode(x);
			map.remove(key);
		}
		
		public int get(int key) {
			if (map.containsKey(key)) {
				
			 	ListNode node = map.get(key);
			 	makeRecently(key);
			 	return node.val;
			}
			return -1;
		}
		
		public void put(int key, int val) {
			if (map.containsKey(key)) {
				// 哈希表中有对应的key
				// 删除旧数据
				deleteKey(key);
				addRecently(key, val);
			} else {
				// 无对应的key
				
				if (cap == cache.size) {
					removeLeastRecently();
				}
				addRecently(key, val);
			}
		}
		
	}
}
