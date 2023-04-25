package 查找和排序;

public class SortTest {

	public void gbSort(int begin, int end) {
		if (end - begin < 2) {
			return;
		}

		int mid = (begin + end) >> 1;
		gbSort(begin, mid);
		gbSort(mid, end);
		merge(begin, mid, end);
	}

	int[] leftArr;
	public void merge(int begin, int mid, int end) {

		int li = 0, le = mid - begin, ri = mid, re = end;
		int ai = begin;

		for (int i = li; i < le; i++) {
			leftArr[i] = arr[begin + i];
		}

		while(li < le) {
			if (ri < re && arr[ri] < leftArr[li]) {
				arr[ai] = arr[ri];
				ai++;
				ri++
			} else {
				arr[ai] = leftArr[li];
				ai++;
				li++
			}
		}
	}
}
