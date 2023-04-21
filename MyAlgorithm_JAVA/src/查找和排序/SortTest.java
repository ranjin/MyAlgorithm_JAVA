package 查找和排序;

public class SortTest {


	// 归并排序
	int[] arr;
	public void sort(int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int mid = (begin + (end - begin)) >> 1;
		sort(begin, mid);
		sort(mid, end);
		merge(begin, mid, end);
	}

	public void merge(int begin, int mid, int end){

		int li = 0, le = mid - begin, ri = mid, re = end;
		int ai = begin;

		int[] leftArr;
		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftArr[i] = arr[i + begin];
		}

		while (li < le) {
			if (ri < re && arr[ri] < left[li]) {
				array[ai] = arr[ri];
				ai++;
				ri++;
			} else {
				array[ai] = left[li];
			}
		}
	}

}
