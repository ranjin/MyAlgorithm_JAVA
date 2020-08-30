package 剑指Offer;

public class 面试题26_复杂链表的复制 {

	public class Node{
		int val;
		Node next;
		Node random;	//指向链表中的任意节点或者null
//		public Node(int val) {
//			this.val = val;
//			this.next = null;
//			this.random = null;
//		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
	
	public static Node CopyRandomList(Node head) {
		//创建新的包含复制节点的链表
		 CreateNewList(head);
		 
		 
		 //设置链表中random节点指向的位置
		 SetRandomNodeNext(head);
		 
		 //分离链表分为原始链表跟复制链表
		 SeparateList(head);
	}
	/*
	 * 在不使用辅助空间的情况下实现O(n)的时间效率。
	 * 根据原始链表的每个节点N创建对应的N'。
	 * 这一次，我们把N'链接在N的后面。
	 */
	
	//创建新的链表及链表上的节点，random节点为null
	public static Node CreateNewList(Node head) {
		Node pNode = head;
		while (pNode != null) {	
			Node pCloneNode = new Node();
			pCloneNode.val = pNode.val;
			pCloneNode.next = pNode.next;
			pCloneNode.random = null;
			
			pNode.next = pCloneNode;
			pNode = pCloneNode.next;
		}
	}
	
	//设置链表上每个节点的random指向的位置
	public static void SetRandomNodeNext(Node head) {
		Node pNode = head;
		while (pNode != null) {
			Node pCloned = pNode.next;
			if (pCloned.random != null) {
				pCloned.random = pNode.random.next;
			}
			pNode = pCloned.next;
		}
	}
	
	/*
	 * 将上面步骤得到的链表。
	 * 把奇数位置的链表连接起来就是复制链表
	 * 偶数对应的是原始链表
	 */
	public static Node SeparateList(Node head) {
		Node pNode = head;
		Node pClonedHead = null;
		Node pClonedNode = null;
		
		/*
		 * 这个if判断最后执行下来是：
		 * pClone为pNode的后面一个元素。比如A -> A' -> B -> B'
		 * 那么pClone为A'，pNode为B
		 */
		if (head != null) {
			//初始化复制链表的表头
			pClonedHead = head.next;
			pClonedNode = head.next;
			pNode = pNode.next;
		}
		
		while (pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}
}









