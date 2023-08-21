package 数组;

/**
 * 给定一个整数数组nums和一个整数目标值target，
 * 请在数组中找出和为目标值taget的那两个整数，并返回它们的数组下标。
 * nums = [2, 7, 11, 15], taget = 9
 * 数组[0, 1]
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeeCode01_两数之和 {
	/*
	 * 解法1: 穷举，时间复杂度O(n^2), 空间复杂度O(1)
	 */
	public int[] twoSum(int[] sums, int target) {
		if (sums.length == 0) {
			return new int[] {0, 0};
		}
		for (int i = 0; i < sums.length; i++) {
			for (int j = i+1; j < sums.length; j++) {
				if (sums[i] + sums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	/*
	 * 通过哈希表减少时间复杂度
	 * 对于一个元素nums[i], 你想知道有没有另一个元素nums[i]的值为target - nums[i]
	 * 用哈希表记录每个元素的值到索引的映射。这样就能判断数组中是否有一个值为target - nums[i]的元素了
	 * 
	 * 时间复杂度为O(N), 空间复杂度O(N)
	 */
	public int[] twoSum2(int[] sums, int target) {
		int n = sums.length; 
		// 构造哈希表：元素映射到对应的索引
		HashMap<Integer, Integer> valueToIndex = new HashMap<>();
		for (int i = 0; i < sums.length; i++) {
			// 查表，看是否有能和nums[i]凑出target的元素
			int need = target - sums[i];
			if (valueToIndex.containsKey(need)) {
				return new int[] {valueToIndex.get(need), i};
			}
			// 存入val -> index的映射
			valueToIndex.put(sums[i], i);
		}
		return null;
	}
}















