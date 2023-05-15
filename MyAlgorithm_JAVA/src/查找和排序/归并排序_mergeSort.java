package 查找和排序;

public class 归并排序_mergeSort {	
	// 对[begin, end)范围内的元素进行归并排序
	public static void sort(int[] nums, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int mid = (begin + end) >> 1;
		// 先分割，后merge
		sort(nums, begin, mid);
		// 快速排序有个根结点，为sort(mid + 1, end)
		sort(nums, mid, end);
		
		// merge操作
		merge(nums, begin, mid, end);
	}
	
	/**
	 * 将[begin, mid)和[mid, end)范围的序列合并为一个有序序列
	 * 为了更好的merge操作，最好将其中1组序列备份出来，比如[begin, mid)
	 * 
	 * 左边数组是li ～ le，右边数组是ri ～ re
	 */
	public static void merge(int[] nums, int begin, int mid, int end) {
		int[] leftnums = new int[nums.length >> 1];
		// 首先确定li le的值
		// li le为左边数组(基于leftnums)
		int li = 0;
		int le = mid - begin;
		
		// 右边数组(基于nums)
		int ri = mid;
		int re = end;
		
		// nums的索引
		int ai = begin;
		
		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftnums[i] = nums[begin + i];
		}
		
		while (li < le) {
			// 如果左边还没有结束
			// 这里加上==号是为了更稳定点。这样右边大于左边的时候，不会调换
			if (ri < re && leftnums[li] > nums[ri]) {
				/**
				 * 左边比较大
				 * 用nums[ri]的东西覆盖nums[ai]的
				 */
				nums[ai] = nums[ri];
				ai++;
				ri++;
			} else {
				/**
				 * nums[ri] >= leftnums[li]
				 * 右边比较大，li++ ai++ ri不变
				 * 用leftnums的东西覆盖nums上的ai
				 * 有一个异常case，就是：右边数组提前结束，那么只需要将左边全部挪到右边即可
				 */
				nums[ai] = leftnums[li];
				li++;
				ai++;
			}
		}
	}
	public static void main(String[] args) {
    	int[] nums = new int[] {5, 12, 3, 4, 19, 28, 24};
    	sort(nums, 0, nums.length);
    	for (int i : nums) {
            System.out.println(i);
		}
	}
}
