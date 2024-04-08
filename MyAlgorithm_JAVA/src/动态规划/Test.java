package 动态规划;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * LRU算法
 * 哈希链表：哈希表 + 双向链表
 * 
 * @author wodediannao
 *
 */

public class Test {

	/**
	 * dp[i][j] nums1的
	 */
    public int longestCommonSubsequence(String text1, String text2) {
    	int m = text1.length(), n = text2.length();
    	
    	if (m == 0 || n ==0) {
			return 0;
		}
    	int[][] dp = new int[m + 1][n + 1];
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[], j)
				}
			}
		}
    }
	public class Node {
		int val;
		int key;
		Node prev;
		Node next;
		public Node(int val, int key) {
			this.key = key;
			this.val = val;
		}
	}
	
	/// 构建双向链表(头尾指针, 大小)
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
		/**
		 * 头部为久未使用元素，尾部为最新使用元素
		 * 提供方法：
		 * 1. 队尾插入节点
		 * 2. 删除表头节点
		 * 3. 删除某个节点
		 * 4. 返回链表大小
		 */
		/**
		 * head -> x -> tail
		 * head <- x <- tail
		 */
		public void addLast(Node x) {
			x.prev = tail.prev;
			x.next = tail;
			tail.prev.next = x;
			tail.prev = x;
			size++;
		}
		
		/**
		 * node1 -> x -> node2
		 * node1 <- x <- node2
		 */
		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}
		
		
		public Node removeFirst(Node x) {
			if (head.next == null) {
				return  null;
			}
			remove(head.next);
			return head.next;
		}
		
		public int size() {
			return size;
		}
	}
	
	public class LRUCache {
		// 哈希表 + 链表声明
		private HashMap<Integer, Node> map;
		private DoubleList cache;
		// 容量
		private int cap;
		
		public LRUCache(int capacity) {
			this.cap = capacity;
			map = new HashMap<>();
			cache = new DoubleList();
		}
		
		
		/**
		 * 几个方法:
		 * 1. makeRecently:
		 */
		public void makeRecently(int key) {
			// 删除元素，插入队尾
			
		}
		
		public void addRecently(int key, int val) {
			// 添加到表尾
		}
		
		public void deleteKey(int key) {
			// 删除元素
		}
		
		public void removeLeastRecently() {
			// 删除久未使用元素
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
				deleteKey(key);
				addRecently(key, val);
				return;
			}
			if (cap == cache.size()) {
				removeLeastRecently();
			}
			addRecently(key, val);
		}
	}
}


