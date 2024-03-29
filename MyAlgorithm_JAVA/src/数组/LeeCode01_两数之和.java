package 数组;
import java.util.HashMap;

/**
 * 给定一个整数数组nums和一个整数目标值target，
 * 请在数组中找出和为目标值taget的那两个整数，并返回它们的数组下标。
 * nums = [2, 7, 11, 15], taget = 9
 * 数组[0, 1]
 */

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
	
	/// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
	/*
	 * 通过哈希表减少时间复杂度
	 * HashMap(val, index)
	 * 时间复杂度为O(N), 空间复杂度O(N)
	 * 如果contain这个值，那么直接可以获取到这个元素在哈希表中的索引。
	 */
	public int[] twoSum2(int[] sums, int target) {
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















