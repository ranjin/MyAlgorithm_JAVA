package 查找和排序;

/**
 * 快排
 * 根左右
 * 类似于二叉树的前序遍历
 * @author ranjin
 *
 */
public class SortTest {
	public static void quickSort(int[] array, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int partition = findPartition(array, begin, end);
		quickSort(array, begin, partition);
		quickSort(array, partition + 1, end);
	}
	
	public static int findPartition(int[] array, int begin, int end) {
		
		end--;
		int partition = array[begin];
		while (begin < end) {
			
			while (begin < end) {
				// 默认从右到左
				if (array[end] > partition) {
					end--;
				} else {
					array[begin] = array[end];
					begin++;
					break;
				}
			}

			while (begin < end) {
				// 从左到右
				if (array[begin] < partition) {
					begin--;
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
    	quickSort(nums, 0, nums.length);
    	for (int i : nums) {
            System.out.println(i);
		}
	}
}
