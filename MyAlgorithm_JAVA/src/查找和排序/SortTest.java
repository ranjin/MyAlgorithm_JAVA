package 查找和排序;

// 快速排序：不断寻找轴点元素的过程。前序遍历
public class SortTest {
	
	int[] array;
	public void sort(int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int middle = findPartition(begin, end);
		sort(begin, middle);
		sort(middle + 1, end);
	}
	
	public int findPartition(int begin, int end) {
		int partition = array[begin];
		
		while (begin < end) {
			
			while (begin < end) {
				// 从右向左
				if (array[end] > partition) {
					end--;
				} else {
					array[begin] = array[end];
					begin++;
					break;
				}	
			}
			
			while (begin < end) {
				// 从左向右
				if (array[begin] < partition) {
					begin++;
				} else {
					array[end] = array[begin];
					end--;
					break;
				}	
			}
		}
		array[begin] = partition;
		return begin;
	}
}
