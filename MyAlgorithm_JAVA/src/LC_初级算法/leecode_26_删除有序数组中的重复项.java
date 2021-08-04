package LC_初级算法;

/*
 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 
 思路：快慢指针，将不相同的数组元素都移到数组左侧
 */

// 【1,3,5,5,6】
public class leecode_26_删除有序数组中的重复项 {
	
    public static int removeDuplicates(int[] nums) {
    	int length = nums.length;
    	
    	int slow = 0, fast = 1;
    	
    	// fast < length
    	while (fast < length) {
        	if (nums[slow] == nums[fast]) {
    			fast++;
    		}else {
    			slow++;
    			nums[slow] = nums[fast];
    			fast++;
    		}
		}
    	return slow+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0, 0, 1, 1, 3, 5, 5, 6};
		int count = removeDuplicates(nums);
		System.out.print(count);
	}

}
