import java.util.LinkedHashMap;

public class LRU {

	//创建节点类
	class Node{
		public int key, val;
		public Node next, prev;
		public Node(int k, int v) {
			this.key = k;
			this.val = v;
		}
	}
	
	//根据节点类创建双向链表类
	class DoubleList{
		//头尾虚节点
		private Node head, tail;
		
		//链表元素数
		private int size;
		
		public DoubleList(){
			head = new Node(0, 0);
			tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
	}
	
	class LRUCache{
		int cap;	//容量
		LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();
		public LRUCache(int capacity) {
			this.cap = capacity;
		}
		
		//通过key值获取
		public int get(int key) {
			if (!cache.containsKey(key)) {
				return -1;
			}
			
			//将key变为最近使用
			makeRecently(key);
			return cache.get(key);
		}
		
		public void put(int key, int val) {
			if (cache.containsKey(key)) {
			//修改key的值
				cache.put(key, val);
				makeRecently(key);
				return;
			}
			
			if (cache.size() >= this.cap) {
				//链表头部就是最久未使用的key
				int oldestKey = cache.keySet().iterator().next();
				cache.remove(oldestKey);
			}
			
			//将新的key添加链表尾部
			cache.put(key, val);
		}
		private void makeRecently(int key) {
			int val = cache.get(key);
			
			//删除key，重新插入到队尾
			cache.remove(key);
			cache.put(key, val);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
