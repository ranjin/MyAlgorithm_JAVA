package 数组;
/**
 * 移除数组nums中值为val的元素，返回移除后数组的新长度
 * 
 * [3,2,2,3] val = 3，输出[2, 2]
 * 思路：
 */

public class leecode27_移除元素 {
    public int removeElement(int[] nums, int val) {
    	int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 双指针技巧，需要保证nums[0, slow-1]之间的元素都是不含val的
        // 相等的时候直接跳过，不等的时候操作
        int slow = 0, fast = 0;
        while (fast < n) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			// 等于val时，fast++
			fast++;
		}
        return slow;
    }
}
