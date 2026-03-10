package 查找和排序;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeeCode.LRUCacheDemo.ListNode;

public class SortTest {


	// LRU缓存淘汰策略
	// 哈希链表: 

	public class Node {
		int key;
		int val;
		Node prev;
		Node next;
		public Node(int key, int val){
			this.key = key;
			this.val = val;
		}
	}

	// 双向链表
	public class DoubleList {
		Node head;
		Node tail;
		int size;
		public DoubleList() {
			head = new Node(0, 0);
			tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		// 左边表头，右边表尾，表尾为最近添加元素
		// node1 -> x -> tail
		// node1 <- x <- tail
		public void addLast(Node x) {
			x.prev = x.next.prev;
			x.next = tail;

			tail.prev.next = x;
			tail.prev = x;
			size++;
		}

		// node1 -> x -> node2
		// node1 <- x <- node2
		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}

		// 删除表头元素(久未使用)
		public Node removeFirst() {

			if (head.next == tail) {
				return null;
			}
			Node first = head.next;
			remove(first);
			return first;
		}

		public int size() {
			return size;
		}
	}

	public class LRUCache {


		private HashMap<Integer, Node> map;
		private DoubleList cache;

		private int capacity;

		public LRUCache(int cap){
			map = new HashMap<>();
			cache = new DoubleList();
			this.capacity = cap;
		}

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

		public int deleteKey(int key) {
			Node x = map.get(key);
			cache.remove(x);
			map.remove(key);
			return x.val;
		}

		public void removeLeastRecently() {
			cache.removeFirst();
		}


		// 重要的两个方法

		// 返回的是val，不是key
		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			// 包含
			makeRecently(key);
			return map.get(key).val;
		}

		public void put(int key, int val) {
			if (map.containsKey(key)) {
				deleteKey(key);
				addRecently(key, val);
				return;
			}
			// 不包含
			if (capacity == cache.size()) {
				removeLeastRecently();
			}
			addRecently(key, val);
		}

		
	}
}