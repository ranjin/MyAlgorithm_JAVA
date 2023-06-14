package 查找和排序;

/**
 * 快排
 * 根左右
 * 类似于二叉树的前序遍历
 * @author ranjin
 *
 */
public class SortTest {
	
	// 归并排序
	// 后序遍历，左右根
	public static void sort(int[] array, int begin, int end) {
		
		// 先排序，后merge
		int mid = (end - begin) / 2;
		sort(array, begin, mid);
		sort(array, mid, end);
		merge(array, begin, mid, end);
	}
	
	
	public static void merge(int[] array, int begin, int mid, int end) {
		// 备份左边数组
		int li = 0, le = mid - begin, ri = mid, re = end; 
		
		// 数组索引
		int ai = begin;
		
		int[] leftArray = new int[le];
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}
		
		while (li < le) {
			// 左边比较大
			if (ri < re && leftArray[li] > array[ri]) {
				array[ai] = array[ri];
				ai++;
				ri++;
			} else {
				// 右边比较大
				array[ai] = leftArray[li];
				ai++;
				li++;
			}
		}
	}
	
//	public static void sort(int[] array, int begin, int end) {
//		if (end - begin < 2) {
//			return;
//		}
//		int partition = findPartition(array, begin, end);
//		
//		sort(array, begin, partition);
//		sort(array, partition + 1, end);
//	}
//	
//	public static int findPartition(int[] nums, int begin, int end) {
//		
//		int partition = nums[begin];
//		end--;
//		while (begin < end) {
//			// 默认从右向左
//			while (begin < end) {
//				if (nums[end] > partition) {
//					end--;
//				} else {
//					// 比partition小的元素放左边,直接覆盖begin的位置
//					nums[begin] = nums[end];
//					begin++;
//					break;
//				}
//			}
//			
//			// 从左到右
//			while (begin < end) {
//				if (nums[begin] < partition) {
//					begin++;
//				} else {
//					// nums[end] <= partition
//					nums[end] = nums[begin];
//					end--;
//					break;
//				}
//			}	
//		}
//		nums[begin] = partition;
//		return begin;
//	}
}
