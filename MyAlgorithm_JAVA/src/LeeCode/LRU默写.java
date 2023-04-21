
public class LRUCache {

	
	public class Node {
		int key;
		int val;
		Node prev;
		Node next;
	}

	public class DoubleList{

		Node head;
		Node tail;
		int size;
		public DoubleList(){
			head = new Node(0, 0);
			tail = new Node(0, 0);
			size = 0
		}
	}

	/**
	 * head -> tail
	 * head -> x -> tail
	 * 队尾为最近使用，队头为久未使用
	 */

	public void addLast(Node x) {
		// 队尾添加元素
		x.prev = tail.prev;
		x.next = tail;
		tail.prev.next = x;
		tail.prev = x;
		size++;
	}

	/**
	 * head -> x -> tail
	 * head -> tail
	 */
	// 删除指定元素
	public void remove(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}

	// 删除链表首个元素并返回
	public void removeFirst(){
		//
		if (head.next == null) {
			return;	
		}
		Node x = head.next;
		remove(x);
		return x;
	}

	public int size(){
		return size;
	}

	public class LRUCach {
		HashMap<Integer, Node> map;
		DoubleList cache;
		int cap;
		public LRUCach(int capacity){
			map = new HashMap<>();
			cache = new DoubleList();
			this.cap = capacity;
		}

		// 四个方法
		public void makeRecently(int key){
			Node x = map.get(key);
			cache.remove(x);
			cache.addLast(x);
		}

		public void addRecently(int key, int val) {
			Node node = new Node(key, val);
			cache.addLast(node);
			map.put(key);
		}

		public void deleteKey(int key) {
			Node x = map.get(key);
			cache.remove(x);
			map.remove(key);
		}

		// 删除链表头部元素
		public void removeLeastRecently(){
			Node x = cache.removeFirst();
			map.remove(x.val);
		}


		// 
		public void get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			makeRecently(key);
		}


		public void put(int key, int val){
			if(map.containsKey(key)) {
				deleteKey(key);
			} else {
				// 不包含
				if (cap == cache.size()) {
					removeLeastRecently();
				}
			}
			addRecently(key, val);
		}
	}

}