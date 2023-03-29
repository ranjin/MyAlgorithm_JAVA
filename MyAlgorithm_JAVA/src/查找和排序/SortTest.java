package 查找和排序;

public class SortTest {
	int[] arr;
	// 左边数组备份
	int[] leftArr;
	public void sort(int begin, int end) {
		
		if (end - begin < 2) {
			return;
		}
		int mid = (end - begin) >> 1;
		sort(begin, mid);
		sort(mid, end);
		merge(mid, begin, end);
	}
	
	public void merge(int begin, int mid, int end) {
		int[] leftArray = null;
		int li = 0, le = mid - begin, ri = mid, re = end;
		int ai = begin;
		
		for (int i = li; i < le; i++) {
			leftArray[i] = arr[i + begin];
		}
		
		while (li < le) {
			// 左边比较大
			if (ri < re && arr[ri] < leftArray[li]) {
				arr[ai] = arr[ri];
				ai++;
				ri++;
			} else {
				arr[ai] = leftArray[li];
				ai++;
				li++;
			}
		}
	}
}
