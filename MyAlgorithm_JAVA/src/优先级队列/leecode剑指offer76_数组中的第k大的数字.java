package 优先级队列;

import java.util.PriorityQueue;

/**
 * 输入: [3,5,6] 和 k = 1
 * 输出: 5、6
 * 
 * 采用优先级队列：二叉堆的一个应用
 * 优先级队列默认是小顶堆。
 * 如果要声明一个大顶堆:
 */
public class leecode剑指offer76_数组中的第k大的数字 {

    public int findKthLargest(int[] nums, int k) {
    	// 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 大顶堆的声明
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (b.val - a.val));

        for (int e : nums) {
        	// 每个元素都要过一遍二叉堆
			pq.offer(e);
			// 堆中元素多于k个时，删除堆顶元素
			if (pq.size() > k) {
				pq.poll();
			}
		}
        // pq中剩下的是nums中k个最大元素
        // 堆顶就是最小的那个，即第k个最大元素
        return pq.peek();
    }
}
