package 递归与回溯;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new test().isValid("{}"));
		int[] nums = {1, 2, 2, 4};
		int[] arr = new test().findErrorNums(nums);
		System.out.println(new test().findErrorNums(nums));
	}
	boolean isValid(String str) {
		Stack<Character> left = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == '{' | c == '[') {
				left.push(c);
			}else {
				if (!left.empty() && leftof(c) == left.peek()) {
					left.pop();
				}else {
					return false;
				}
			}
		}
		return left.empty();
	}
	char leftof(char c) {
		if (c == '}') {
			return '{';
		}
		if (c == ')') {
			return '(';
		}
		return '[';
	}
	
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		if (nums[nums.length - 1] != nums.length) {
			return nums.length;
		}
		if (nums[0] != 0) {
			return 0;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int exceptedNum = nums[i-1] + 1;
			if (nums[i] != exceptedNum) {
				return exceptedNum;
			}
		}
		return -1;
	}
	
	public int missingNumber2(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : nums) {
			numSet.add(num);
		}
		
		int expectedNumCount = nums.length + 1;
		for (int number = 0; number < expectedNumCount; number++) {
			if (!numSet.contains(number)) {
				return number;
			}
		}
		return -1;
	}
	
	public int missingNumber3(int[] nums) {
		int n = nums.length;
		int res = 0;
		res ^= n;
		for (int i = 0; i < n; i++) {
			res ^= i ^ nums[i];
		}
		return res;
	}
	
	//sums: [1,-2,2,4]
	//index: 0,1,2,3  
	public int[] findErrorNums(int[] nums) {
		//寻找重复的元素
		int count = nums.length;
		int dup = -1;
		for (int i = 0; i < count; i++) {
			//先获取到索引
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				dup = Math.abs(nums[i]);
			}else {
				nums[index] *= -1;
			}
		}
		
		//寻找丢失的元素
		int missing = -1;
		for (int i = 0; i < count; i++) {
			//nums[i]大于0则说明没有访问
			if (nums[i] > 0) {
				missing = i+1;
			}
		}
		return new int[] {dup, missing};
	}
}











