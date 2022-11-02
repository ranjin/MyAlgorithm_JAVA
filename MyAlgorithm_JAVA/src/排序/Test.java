package 排序;

public class Test {

	public void sort(int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int middle = pivotIndex(begin, end);
		sort(begin, middle);
		sort(middle + 1, end);
		
	}
	
	public int pivotIndex(int begin, int end) {
		int[] array = null;
		int pivot = array[begin];
		end--;
		
		while (begin < end) {
			while (begin < end) {
				// 从右边向左边
				if (array[end] > pivot) {
					end--;
				} else {
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			
			while (begin < end) {
				// 从右边向左边
				if (pivot > array[begin]) {
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
