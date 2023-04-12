package 递归与回溯;

public class 去除有序数组中的重复元素 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,6,6,7,8};
		System.out.println(removeDuplicates(nums));
	}
	/*
	 * slow   fast
	 *  0		1		1		2		2		3
	 */
	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int slow = 0, fast = 1;
		while (fast < n) {
			/*
			 * 如果不相等，将fast位置上的元素赋值给slow上
			 * slow后移，fast后移
			 * 
			 * 如果相等，fast后移
			 */
			if (nums[fast] != nums[slow]) {
				slow++;
				nums[slow] = nums[fast];
				fast++;
			}else {
				fast++;
			}
		}
		//长度索引
		return slow + 1;
	}
}








