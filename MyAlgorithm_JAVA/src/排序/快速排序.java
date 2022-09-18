package 排序;

public class 快速排序 {

	int[] array;
	public void sort(int begin, int end) {
		// 临界case
		if (end - begin < 2) {
			return;
		}
		
		// begin元素的复制 pivot为分割点
		int mid = pivotIndex(begin, end);
		sort(begin, mid);
		sort(mid + 1, end);
	}
	
	public int pivotIndex(int begin, int end) {
		int pivot = array[begin];
		end--;
		while (begin < end) {
			while (begin < end) {
				// 默认从右向左
				if (array[end] > pivot) {
					end--;
				} else {
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			
			while (begin < end) {
				if (array[begin] < pivot) {
					begin++;
				} else {
					array[end] = array[begin];
					end--;
					break;
				}
			}
		}
		array[begin] = pivot;
		return begin;
	}
}
