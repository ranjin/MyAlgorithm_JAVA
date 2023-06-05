package 查找和排序;

public class SortTest {

	
	// 快速排序
	public static void sort(int[] array, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int partition = findPartition(array, begin, end);
		sort(array, begin, partition);
		sort(array, partition + 1, end);
	}
	
	public static int findPartition (int[] array, int begin, int end) {
		
		end--;
		int partition = array[begin];
		
		while (begin < end) {
			// 默认从右向左
			while (begin < end) {
				if (array[end] > partition) {
					end--;
				} else {
					array[begin] = array[end];
					begin++;
					break;
				}	
			}
			
			while (begin < end) {
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
	
	public static void main(String[] args) {
    	int[] nums = new int[] {5, 12, 3, 4, 19, 28, 24};
    	sort(nums, 0, nums.length);
    	for (int i : nums) {
            System.out.println(i);
		}
	}
}
