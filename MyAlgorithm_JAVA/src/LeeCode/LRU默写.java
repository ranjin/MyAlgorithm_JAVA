package LeeCode;

import java.awt.RenderingHints.Key;
import java.util.HashMap;

class LRUCache {

	public class Node{
		int key;
		int val;
		Node next;
		Node prev;
		public Node(int k, int v) {
			this.key = k;
			this.val = v;
		}
	}

	// 链表左边是头，右边是尾。最近使用的放在尾部
	public class DoubleList {
		Node head;
		Node tail;
		int size;
		public DoubleList(){
			head = new Node(0, 0);
			tail = new Node(0, 0);
			size = 0;
		}
		
		/**
		 * 1. 在尾部添加节点
		 * 2. 删除表头节点
		 * 3. 删除某个节点
		 * 4. 返回链表size
		 */
		
		public void addLast(Node x) {
			x.prev = tail.prev;
			x.next = tail;
			tail.prev.next = x;
			tail.prev = x;
			size++;
		}
		
		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}
		
		public Node removeFist(){
			Node first = head.next;
			remove(first);
			return first;
		}
		
		public int size() {
			return size;
		}
		
	}
	
	
	// 双向链表(LinkedHashMap)
	
	private HashMap<Integer, Node> map;
	private DoubleList cache;
	private int cap;
    public LRUCache(int capacity) {
		this.cap = capacity;
		this.map = new HashMap<>();
		this.cache = new DoubleList();
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
    
    public void deleteKey(int key) {
    	Node x = map.get(key);
    	cache.remove(x);
    	cache.addLast(x);
    	map.remove(key);
    }
    
    public void removeLastRecently() {
    	Node deleteNode = cache.removeFist();
    	int key = deleteNode.val;
    	map.remove(key);
    }
    
    
    public int get(int key) {
    	if (!map.containsKey(key)) {
			return -1;
		}
    	makeRecently(key);
    	return map.get(key).val;
    }
    
    public void put(int key, int value) {
    	if (map.containsKey(key)) {
			deleteKey(key);
			addRecently(key, value);
			return;
		}
    	if (cap == cache.size) {
			removeLastRecently();
		}
    	addRecently(key, value);
    }
}
