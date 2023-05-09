package 单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，下一个更大元素是 3 。
 * - 2 ，不存在下一个更大元素，所以答案是 -1 。
 * 
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，下一个更大元素是 3 。
 * - 4 ，不存在下一个更大元素，所以答案是 -1 。
 * 
 * 思路：
 * 可以根据单调栈模版求出nums2的单调递增数组，然后以nums1中的元素为索引。
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] greateNums = nextGreaterElement(nums2);
    	
    	int[] res = new int[nums1.length + 1];
    	
    	// 建立映射关系
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	
    	for (int i = 0; i < nums2.length; i++) {
			hashMap.put(nums2[i], greateNums[i]);
		}
    	
    	for (int i = 0; i < nums1.length; i++) {
			res[i] = hashMap.get(nums1[i]);
		}
    	return res;
    }

    
    // 单调栈模版
    int[] nextGreaterElement(int[] nums) {
    	int n = nums.length;
    	int[] res = new int[n];
    	Stack<Integer> s = new Stack<>();
    	for (int i = n - 1; i >= 0; i--) {
			
    		while (!s.isEmpty() && nums[i] >= s.peek()) {
				s.pop();
			}
    		res[i] = s.isEmpty() ? -1 : s.peek();
    		s.push(nums[i]);
		}
    	return res;
    }
}