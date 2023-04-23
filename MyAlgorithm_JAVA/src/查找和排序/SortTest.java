package 查找和排序;

public class SortTest {
	/**
	 * 归并排序：
	 * 类似于二叉树的后序遍历。
	 */

	int[] arr;
	public void sort(int begin, int end) {

		if (end - begin < 2) {
			return;
		}

		int mid = (begin + end) >> 1;
		sort(begin, mid);
		sort(mid, end);

		merge(begin, mid, end);
	}

	int[] leftArr;
	public void merge(int begin, int mid, int end) {
		int li = 0, le = mid - begin, ri = mid, re = end;
		int ai = begin;

		// 左边数组备份
		for (int i = li; i < le; i++) {
			leftArr[i] = arr[begin + i];
		}


		while(li < le) {
			if (ri < re && leftArr[li] > array[ri]) {
				array[ai] = array[ri];
				ai++;
				ri++;
			} else {
				array[ai] = leftArr[li];
				ai++;
				li++;
			}
		}
	}

}
