
public class Node {
	int key;
	int val;
	Node prev;
	Node next;
}

public class DoubleList {
	int cap;
	Node head;
	Node tail;
	public DoubleList (int capacity) {
		this.cap = capacity;
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
	}
}


// 哈希表 + 双向链表
public class LRUCache {
	HashMap<Integer, Node> map;
	DoubleList cache;

	/**
	 * 链表： 表尾为最近使用元素，表头为久未使用元素
	 * 链表方法：
	 * 1. 
	 */
	// 表尾添加元素
	// node1 -> tail
	// node1 -> x -> tail
	// node1 <- x <- tail
	public void addLast(Node x) {
		x.prev = tail.prev;
		x.next = tail;
		tail.prev.next = x;
		tail.prev = x;
		size++;
	}

	// 删除指定元素
	// node1 -> x -> node2
	// node2 <- x <- node1
	public void remove(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;
	}

	// 删除表头元素，即删除久未使用元素
	public Node removeFirst() {
		if (head.next == null) {
			return null;
		}
		Node first = head.next;
		remove(first);
		return first;
	}

	// 链表长度
	public int size() {
		return size;
	}


	
	// 哈希链表方法：
	// 将某个key提升为最近使用元素
	public void makeRecently(int key) {
		Node x = map.getKey(key);

		cache.remove(x);
		cache.addLast(x);
	}

	public void addRecently(int key, int val) {
		Node x = new Node(key, val);

		cache.addLast(x);
		map.put(key, x);
	}

	public void deleteKey(int key) {
		Node x = map.getKey(key);
		cache.remove(x);
		map.remove(key);
	}

	// 删除久未使用元素
	public deleteLeastRecently() {
		Node x = cache.removeFirst();
		map.remove(x.val);
	}


	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		makeRecently(key);
		return map.getKey(key).val;
	}


	public void put(int key, int val) {
		// 如果map中存在与key值相同的
		if (!map.containsKey(key)){
			// 删除旧值
			deleteKey(key);
		}

		if (cap = cache.size()) {
			// 删除久未使用元素
			deleteLeastRecently()
		}

		addRecently(key, val);
		Node x = new Node(key, val);

	}
}