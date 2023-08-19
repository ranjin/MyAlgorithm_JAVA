package 查找和排序;

public class SortTest {

	

	// 快速排序
	public static void quickSort(int[] nums, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int mid = findPartition(nums, begin, end);
		quickSort(nums, begin, mid);
		quickSort(nums, mid + 1, end);		
	}
	
	public static int findPartition(int[] nums, int begin, int end) {
		
		int partition = nums[begin];
		end--;
		while (begin < end) {
			
			while (begin < end) {
				if (nums[end] > partition) {
					end--;
				} else {
					// nums[end] <= partition
					nums[begin] = nums[end];
					begin++;
					break;
				}
			}
			
			while (begin < end) {
				if (nums[begin] < partition) {
					begin++;
				} else {
					// nums[end] <= partition
					nums[end] = nums[begin];
					end--;
					break;
				}
			}
		}
		
		nums[begin] = partition;
		return begin;
	}
	public static void main(String[] args) {
    	int[] nums = new int[] {5, 12, 3, 4, 19, 1, 28, 24};
    	quickSort(nums, 0, nums.length);
    	for (int i : nums) {
            System.out.println(i);
		}
	}
}
