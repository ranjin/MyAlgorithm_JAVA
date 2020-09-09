package 剑指Offer;

import java.util.HashMap;

/*
 * the sky is blue!
 * 
 * blue! is sky the
 */
public class Test2 {

	//声明Node
	public class Node{
		int val;
		int key;
		Node prev;
		Node next;
	}
	
	/*
	 * 双向链表
	 * 表头相当于是最久未使用的元素，表头是最近使用的元素
	 */
	public class DoubleList{
		Node head;
		Node tail;
		int size;
		public DoubleList() {
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		//双向链表常用的几个API
		//表尾添加元素
		public void addToLast(Node x) {
			x.next = x.prev.next;
			x.next = tail;
			
			tail.prev.next = x;
			tail.prev = x;
		}
		
		//删除表头元素
		public Node removeFirst() {
			if (head == null) {
				return null;
			}
			Node first = head.next;
			removeNode(first);
			return first;
		}
		
		//删除链表中的元素，并返回
		public void removeNode(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}
		
		public int size() {
			return size;
		}
	}
	
	public class LRUCache{
		//采用双向链表来实现
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		DoubleList cache = new DoubleList();
		//容量
		int capacity;
		
		
		//几个常用的API
		
		/*
		 * 将某个节点设置为最常使用的
		 * 需要先删除，然后移到表尾
		 */
		public void makeRecently(int key) {
			Node x = map.get(key);
			cache.removeNode(x);
			cache.addToLast(x);
		}
		
		//移除最久未使用元素，即表头Node
		public void removeLeastRecently() {
			Node deletedNode = cache.removeFirst();
			int deleteKey = deletedNode.val;
			map.remove(deleteKey);
		}
		
		//添加到表尾
		public void addRecently(int key, int value) {
			Node x = new Node();
			cache.addToLast(x);
			map.put(key, x);
		}
		
		//删除某个元素
		public void deleteKey(int key) {
			map.remove(key);
			Node x = map.get(key);
			cache.removeNode(x);
		}
		//
		public void put(int key, int value) {
			if (map.containsKey(key)) {
				deleteKey(key);
				addRecently(key, value);
				return;
			}
			if (capacity == map.size()) {
				removeLeastRecently();
			}
			addRecently(key, value);
		}
		
		/*
		 * get方法
		 * 如果不存在，返回-1
		 * 
		 */
		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			makeRecently(key);
			return map.get(key).val;
		}
		
		public int size() {
			return capacity;
		}
	}
	
}












