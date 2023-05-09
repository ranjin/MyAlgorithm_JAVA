package 单调栈;

import java.util.Stack;

/**
 * 环形数组
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * 
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 */

/**
 * 技巧：一般通过%运算符求模(余数),来模拟环形特效。
 * 数组长度加倍模拟环形数组
 *
 */
public class leecode503_下一个更大元素2 {

    public int[] nextGreaterElements(int[] nums) {
    	int n = nums.length;
    	Stack<Integer> s = new Stack<>();
    	int[] res = new int[n];
    	for (int i = 2 * n - 1; i >= 0; i--) {
			while (!s.isEmpty() && nums[i % n] >= s.peek()) {
				s.pop();
			}
			res[i % n] = s.isEmpty() ? -1 : s.peek();
			s.push(nums[i % n]);
		}
    	return res;
    }
}
