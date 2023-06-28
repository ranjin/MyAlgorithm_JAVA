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

	/**
	 * 二叉堆解法
	 * 把二叉队理解成一个筛子，较大的元素会沉下去，较小的元素会浮上来。
	 * 进行一次完成的for循环。当堆大小超过K时，我们就删掉堆顶元素，因为这些元素比较小，那么最终留下的，
	 * 就是数组中最大的k个树，那么堆顶元素就是数组中的第k大元素。
	 */
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
    
    /**
     * 加分项：快速选择算法，即快排的变体，效率更高。
     * 
     * 时间复杂度: O(N)
     * 
     * 快排中，partition会将nums[p]排到正确的位置，使得nums[lo..p-1] < nums[p] < nums[p+1..hi]
     * 
     * k' = n - k
     * 虽然整个数组还未排好序，但是已经让nums[p]左边的元素都比nums[p]小了。也就知道nums[p]的排名了。
     * 
     * 此时将p和k'进行比较。如果p < k',说明第k'大的元素在nums[p+1..hi]中。
     * 反之，则说明第k'大的元素在nums[lo..p-1]中
     * 
     * 进一步，在nums[p+1..hi]和nums[lo..p-1]中执行partition函数。这样缩小范围，最终找到目标元素
     */
    public int findKthLargest_02(int[] nums, int k) {
    	    int lo = 0, hi = nums.length - 1;
    	    // k'含义. 转化成「排名第 k 的元素」
    	    k = nums.length - k;
    	    while (lo < hi) {
				int p = findPartition(nums, lo, hi);
				if (p < k) {
					lo = p + 1;
				} else if (p > k) {
					hi = p - 1;
				} else {
					return nums[p];
				}
			}
    	    return -1;
    	}
    
    
	// 寻找分割点
	public static int findPartition(int[] array, int begin, int end) {
		// 备份轴点元素，后面会进行覆盖操作
		int partition = array[begin];
		end--;	// end指向最后一个元素
		while (begin < end) {
			while (begin < end) {
				// 默认从右向左
				if (array[end] > partition) {
					end--;
				} else {
					// 直接覆盖begin位置,begin往右,此时调换方向，从左往右扫描
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			while (begin < end) {
				// 调换方向，从左向右
				if (array[begin] < partition) {
					begin++;
				} else {
					array[end] = array[begin];
					end--;
					break;
				}
			}
		}
		array[begin] = partition; // 备份
		return begin;
	}
}
