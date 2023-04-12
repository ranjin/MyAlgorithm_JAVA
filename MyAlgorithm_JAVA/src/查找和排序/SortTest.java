package 查找和排序;

// 快速排序：前序遍历，不断的寻找轴点， 左 - 轴点 - 右

// 归并排序：先分割完，再合并

public class SortTest {

	int[] array;
	int[] leftArray;
	public void sort (int begin, int end) {
		int middle = (begin + (end - begin)) >> 1;
		sort(begin, middle);
		sort(middle, end);

		// merge
		merge(begin, middle, end);
	}

	public void merge(int begin, int middle, int end) {
		// 备份左边数组
		int li = 0, le = middle - begin, ri = middle, re = end;
		int ai = begin;
		for (int i = li; i < le; i ++) {
			leftArray[i] = array[i];
		}

		while (li < le) {
			// 左边比较大
			if (array[li] > array[ri]) {
				array[ai] = array[ri];
				ai++;
				ri++
			} else {
				array[ai] = array[li];
			}
		}
	}
	//
	// int[] array;
	// public void sort(int begin, int end) {
	// 	int partition = findPartition(begin, end);
	// 	sort(begin, partition);
	// 	sort(partition + 1, end);
	// }

	// public int findPartition(int begin, int end) {
	// 	// 备份轴点元素, 后面会进行覆盖
	// 	int partition = array[begin];
	// 	end--;

	// 	while (begin < end) {

	// 		while (begin < end) {
	// 			// 默认从右向左
	// 			if (array[end] > partition) {
	// 				end--;
	// 			} else {
	// 				// array[end] <= partition
	// 				array[begin] == array[end];
	// 				begin++;
	// 				break;
	// 			}
	// 		}

	// 		while (begin < end) {
	// 			// 从左向右
	// 			if (array[begin] < partition) {
	// 				begin++;
	// 			} else {
	// 				// array[begin] >= partition
	// 				array[end] == array[begin];
	// 				end--;
	// 				break;
	// 			}
	// 		}
	// 	}

	// 	// 备份
	// 	array[begin] = partition;
	// 	return begin;
	// }
}
