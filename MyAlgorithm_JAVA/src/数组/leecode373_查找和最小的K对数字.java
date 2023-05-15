package 数组;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 
 * 输入: nums1 = [1,2], nums2 = [3], k = 3 
 * 输出: [1,3],[2,3]
 *
 */
public class leecode373_查找和最小的K对数字 {
	/**
	 * 思路：
	 * [1, 7, 11]  [2, 4, 6]
	 * 
	 * 初始的三个链表: 
	 * [1, 2, 0],
	 * [7, 2, 0],
	 * [11, 2, 0],
	 * 
	 * [1, 2, 0], next_index = 1, 
	 * 
	 * [1, 4, 1]
	 * 
	 * res = [1, 2]
	 */
	
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<List<Integer>> res = new ArrayList<>();
    	// 三元数组定义 int[] {nums[1], nums[2], i}
    	// i用于记录nums2元素的索引位置，用于生成下一个节点
    	PriorityQueue<int[]> pq = new PriorityQueue<>();
    	for (int i = 0; i < nums1.length; i++) {
			pq.offer(new int[] {nums1[i], nums2[i], 0});
		}
    	
    	while (!pq.isEmpty() && k > 0) {
			int[] cur = pq.poll();
			k--;
			List<Integer> pair = new ArrayList<>();
			pair.add(cur[0]);
			pair.add(cur[1]);
			res.add(pair);
			
			// 链表中的下一个节点加入优先级队列
			int next_index = cur[2] + 1;
			if (next_index < nums2.length) {
				pq.offer(new int[] {cur[0], nums2[next_index], next_index});
			}
		}
    	return res;
    }
}
