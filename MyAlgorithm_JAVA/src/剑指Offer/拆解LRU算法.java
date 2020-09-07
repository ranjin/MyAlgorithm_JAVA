package 剑指Offer;

import java.util.HashMap;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

public class 拆解LRU算法 {
	/*
	 * 构建Node
	 * 为什么需要在链表中同时存储key和val ? 
	 * 因为在移除最近最常使用时，需要用deleteNode得到deletedKey
	 */
	public class Node{
		int val;
		int key;
		Node prev;
		Node next;
	}
	
	/*
	 * 构建双向链表
	 * 为什么要用双向链表? 因为我们需要删除操作
	 * 删除一个节点不光要得到该节点本身的指针，也需要操作其前驱节点的指针。
	 * 
	 * 靠近尾部的元素是最近使用的，越靠头的元素就是最久未使用的
	 */
	public class DoubleList{
		//头尾节点
		Node head;
		Node tail;
		int size;	//链表元素数
		
		public DoubleList{
			//初始化双向链表的数据
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		//在链表尾部添加节点x, 时间O(1)
		public void addLast(Node x) {
			//设置节点的前后驱
			x.prev = tail.prev;
			x.next = tail;
			
			//从尾部开始
			tail.prev.next = x;
			tail.prev = x;
		}
		
		//删除链表中的x节点(x一定存在)
		//由于是双向链表且给的目标Node节点，时间O(1)
		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}
		
		//删除链表中第一个节点,并返回该节点，时间O(1)
		public Node removeFirst() {
			if (head.next == tail) {
				return null;
			}
			Node first = head.next;
			remove(first);
			return first;
		}
		
		//返回链表长度 时间O(1)
		public int size() {
			return size;
		}
	}
	
	public class LRUCache {
		private HashMap<Integer, Node> map;
		private DoubleList cache;
		
		//最大容量
		private int cap;
		public LRUCache(int capacity) {
			this.cap = capacity;
			map = new HashMap<>();
			cache = new DoubleList();
		}
		
		//将某个key提升为最近使用的
		private void makeRecently(int key) {
			Node x = map.get(key);
			
			//先从链表中删除这个节点
			cache.remove(x);
			
			//重新插入到队尾
			cache.addLast(x);
		}
		
		//添加最近使用的元素
		private void addRecently(int key, int val) {
			Node x = new Node();
			
			//链表尾部就是最近使用的元素
			cache.addLast(x);;
			
			map.put(key, x);
		}
		
		//删除某一个key
		private void deleteKey(int key) {
			Node x = map.get(key);
			
			//从链表中删除
			cache.remove(x);
			
			map.remove(key);
		}
		
		//删除最久未使用的元素
		private void removeLeastRecently() {
			//链表头部的第一个元素就是最久未使用的
			Node deleteNode = cache.removeFirst();
			
			//同时从map中删除它的key
			Node deletedNode = cache.removeFirst();
			
			int deleteKey = deletedNode.val;
			
			map.remove(deleteKey);
		}
		
		//LRU算法的get方法
		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			//将该数据提升为最近使用的
			makeRecently(key);
			return map.get(key).val;
		}
		
		//LRU算法的put方法
		public void put(int key, int val) {
			if (map.containsKey(key)) {
				//删除旧的数据
				deleteKey(key);
				
				//新插入的数据为最近使用的数据
				addRecently(key, val);
				return;
			}
			
			if (cap == cache.size()) {
				//删除最久未使用的元素
				removeLeastRecently();
			}
			//添加为最近使用的元素
			addRecently(key, val);
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
