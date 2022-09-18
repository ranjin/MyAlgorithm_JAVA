package 排序;

import java.util.Iterator;

public class 归并排序<T extends Comparable<T>> {

	// 先拷贝出左边数组范围：为整个数组的1/2
	int[] leftArray;
	int[] array;
	// 对[begin, end)范围内的元素进行归并排序
	public void sort(int begin, int end) {
		leftArray = (T[])new Object[end >> 1];
		if (end - begin < 2) {
			return;
		}
		int mid = (begin + end) >> 1;
		sort(begin, mid);
		
		// 快速排序有个根结点，为sort(mid + 1, end)
		sort(mid, end);
		
		merge(begin, mid, end);
		
		
	}
	
	/**
	 * 将[begin, mid)和[mid, end)范围的序列合并为一个有序序列
	 * 为了更好的merge操作，最好将其中1组序列备份出来，比如[begin, mid)
	 * 
	 * 左边数组是li - le，右边数组是ri - re
	 */
	public void merge(int begin, int mid, int end) {
		// 首先确定li le的值
		// li le为左边数组(基于leftArray)
		int li = 0;
		int le = mid - begin;
		
		// 右边数组(基于Array)
		int ri = mid;
		int re = end;
		
		// Array的索引
		int ai = begin;
		
		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}
		
		while (li < le) {
			// 如果左边还没有结束
			// 这里加上==号是为了更稳定点。这样右边大于左边的时候，不会调换
			if (ri < re && array[ri] > leftArray[li]) {
				/**
				 * 右边比较大
				 * 用array[ri]的东西覆盖array[ai]的
				 */
				array[ai] = array[ri];
				ai++;
				ri++;
			} else {
				/**
				 * 左边比较小，li++ ai++ ri不变
				 * 用leftArray的东西覆盖array上的ai
				 * 有一个异常case，就是：右边数组提前结束，那么只需要将左边全部挪到右边即可
				 */
				array[ai] = leftArray[li];
				li++;
				ai++;
			}
		}
		 
	}
}
















