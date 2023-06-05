package 数组;

import java.util.Iterator;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 
 * k = 4时，输出：[4、5、6、7、1、2、3]
 * 
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释: 
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class leecode189_轮转数组 {

	
	/**
	 * nums = [ 1、2、3、4、5、6、7]  原始数组
	 */
	
    public static void rotate(int[] nums, int k) {
    	int n = nums.length;
    	
    	int[] resultArr = new int[nums.length];

    	
    	for (int i = 0; i < k; i++) {
    		resultArr[i] = nums[n - k + i];
		}

    	
    	
    	for (int i = 0; i < (n - k); i++) {
			resultArr[i + k - 1] = nums[i];
		}
    	
    	for (int i : resultArr) {
        	System.out.println(i);
		}

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 4);
	}

}
