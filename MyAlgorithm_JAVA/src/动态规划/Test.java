package 动态规划;

import java.util.HashMap;
import java.util.Stack;

import 二叉树.leecode114_二叉树展开为链表.TreeNode;

public class Test {

	public int[] twoSum2(int[] sums, int target) {
		if (sums.length == 0) {
			return sums;
		}
		
		for (int i = 0; i < sums.length; i++) {
			for (int j = 1; j < sums.length; j++) {
				if (sums[i] + sums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	
	public int[] twoSum(int[] sums, int target) {
		HashMap<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < sums.length; i++) {
			int need = target - sums[i];
			
			if (valueToIndex.containsKey(need)) {
				return new int[] {valueToIndex.get(need), i};
			}
			valueToIndex.put(sums[i], i);
		}
		return null;
	}
}
