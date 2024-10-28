package 查找和排序;

import java.util.PriorityQueue;

public class leecode215_数组中的第K个最大元素 {

	// 示例: 3 - 1 - 4 - 5 - 2 - 9
	// 解法1: 优先级队列
    public int findKthLargest(int[] nums, int k) {
    	/**
    	 * 优先级队列
    	 * 第K个最大元素，使用小顶堆，堆顶元素最小。
    	 * 只保留K个元素，那么堆顶的就是最小的
    	 * 总的时间复杂度为：O(N*LogK) n为数组元素总数， 所以最终的时间复杂度就是O(K) 
    	 */
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);
			if (queue.size() > k) {
				queue.poll();
			}
		}
    	return queue.peek();
    }

    /**
     * 快速选择算法
     * 第K个最大元素，也就是第n-k个元素
     * 一直在进行partition操作：即N + N / 2 + N / 4 = O(N)
     * 时间复杂度为：O(N), 最坏情况是O(N^2)
     */
    public int findKthLargest2(int[] nums, int k) {
    	k = nums.length - k;
    	int lo = 0, hi = nums.length - 1;
    	while (lo < hi) {
        	int partition = findPartition(nums, lo, hi);
        	if (partition < k) {
    			lo = partition + 1;
    		} else if (partition > k){
    			hi = partition - 1;
    		} else {
    			return nums[partition];
    		}	
		}
    	return -1;
    }
    
    /// 寻找轴点元素
    public static int findPartition(int[] nums, int begin, int end) {
		int partition = nums[begin];
		
		nums[begin] = partition;
		
		while (begin < end) {
			
			while (begin < end) {
				/// 默认从右向左
				if (nums[end] > partition) {
					end--;
				} else {
					// nums[end] <= partition
					nums[begin] = nums[end];
					begin++;
					break;
				}
				
			}

			while (begin < end) {
				/// 从左向右
				if (nums[begin] < partition) {
					begin++;
				} else {
					// nums[begin] >= partition
					nums[end] = nums[begin];
					end--;
					break;
				}
			}

		}
		return begin;
    	
	}
}
