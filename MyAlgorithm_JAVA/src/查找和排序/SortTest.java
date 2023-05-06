package 查找和排序;

public class SortTest {

	// 归并排序
	// 后序遍历 左右根
	int[] arr;
	int[] leftArr;
	public void gbSort(int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int mid = (begin + end) >> 1;
		gbSort(begin, mid);
		gbSort(mid, end);
		merge(begin, mid, end);
	}
	
	public void merge(int begin, int mid, int end) {
		// 备份左边数组
		int li = 0, le = mid - begin, ri = mid, re = end;
		int ai = begin;
		for (int i = li; i < le; i++) {
			leftArr[i] = arr[i + begin];
		}
		
		// arr		 right
		// leftarr
		while (li < le) {
			if (arr[ri] < leftArr[li]) {
				arr[ai] = arr[ri];
				ai++;
				ri++;
			} else {
				arr[ai] = leftArr[li];
				ai++;
				li++;
			}
		}
	}
}
