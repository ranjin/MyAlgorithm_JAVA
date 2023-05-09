package 单调栈;
import java.util.Stack;

/**
 * 单调栈：使得每次新元素入栈后，站内的元素都保持有序(单调递增或单调递减)
 * 类似问题，通过处理栈，能够得到一个单调递增的栈
 * 经常用以处理[下一个更大元素][上一个更小元素]等
 * 
 * 可以手写流程试试：栈起到一个辅助栈的作用
 *
 * 看着时间复杂度是O(N^2)，但是每个元素都被push一次，而最多也被pop一次。
 * 所以真正的时间复杂度也就是O(N)
 * 
 */
public class 总结 {
	int[] nextGreaterElement(int[] nums) {
		int n = nums.length;

		Stack<Integer> stack = new Stack<>();
		// 存放答案的数组
		int[] res = new int[n];

		// 倒着往栈里放，为了正着出栈
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
				// 当前元素与下一个更大元素之间的都给删掉
				stack.pop();
			}
			res[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[i]);
		}
		return res;
	};
}
