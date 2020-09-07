package LeeCode;

import java.util.HashMap;

public class LeeCode146_LRU缓存机制 {
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
		
		public DoubleList(){
			//初始化双向链表的数据
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		/*
		 * 双向链表的四个方法：
		 * 1. 尾部添加元素，即为最近使用的
		 * 2. 删除某个节点
		 * 3. 删除表头节点
		 * 4. 返回链表的size
		 */
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
		//声明 哈希表+ 双向链表 + 最大容量
		private HashMap<Integer, Node> map;
		private DoubleList cache;
		
		//最大容量
		private int cap;
		public LRUCache(int capacity) {
			this.cap = capacity;
			map = new HashMap<>();
			cache = new DoubleList();
		}
		
		/*
		 * 重要的几个API
		 * 1. makeRecently ：删除节点且插入到表尾
		 * 2. addRecently  ：插入到表尾
		 * 3. deleteKey    ：两个容器中删除
		 * 4. removeLeastRecently ：删除表头元素 并从两个容器中删除
		 */
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
			Node deletedNode = cache.removeFirst();
			
			//同时从map中删除它的key
			int deleteKey = deletedNode.val;
			map.remove(deleteKey);
		}
		
		/*
		 * 最主要的两个方法：
		 * get: makeRecently
		 * put: 如果容量够，插入到表尾，如果不够，先删除表头元素，然后插入到表尾
		 */
		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			//将该数据提升为最近使用的
			makeRecently(key);
			return map.get(key).val;
		}
		
		
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




























