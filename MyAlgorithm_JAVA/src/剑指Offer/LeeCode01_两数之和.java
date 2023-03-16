package 剑指Offer;

/**
 * 给定一个整数数组nums和一个整数目标值target，请在数组中找出和为目标值taget的那两个整数，并返回它们的数组下标。
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
	 * 时间复杂度为O(N), 空间复杂度O(N)
	 */
	public int[] twoSum2(int[] sums, int target) {
		int n = sums.length; 
		// 构造哈希表：元素映射到对应的索引
		HashMap<Integer, Integer> dataHashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < sums.length; i++) {
			dataHashMap.put(sums[i], i);	//元素映射到索引
		}
		
		for (int i = 0; i < sums.length; i++) {
			int otherNo = target - sums[i];
			if (dataHashMap.containsKey(otherNo) && dataHashMap.get(otherNo) != i) {
				return new int[] {i, dataHashMap.get(otherNo)};
			}
		}
		return new int[] {-1, -1};
	}

	
	/*
	 * 设计一个类，拥有两个API
	 * 
	 */
	public class TwoSum{
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		
		//像数据结构中添加一个数 number
		public void add(int number) {
			/*
			 * getOrDefault: 当Map中有这个key时，就使用这个key值
			 * 如果没有就使用默认值defaultValue
			 */
			freq.put(number, freq.getOrDefault(number, 0) + 1);
		}
		
		//寻找当前结构中是否存在两个数的和为value
		public boolean find(int value) {
			for (int key : freq.keySet()) {
				int other = value - key;
				
				//情况一 [3,3,2,5] 执行find(6)
				if (other == key && freq.get(key) > 1) {
					return true;
				}
				
				//情况二 [3,3,2,5] 执行find(7)
				if (other != key && freq.containsKey(other) ) {
					return true;
				}
			}
			return false;
		}
	}
	
	//对于频繁使用find方法的场景
	public class TowSum3{
		Set<Integer> sum = new HashSet<Integer>();
		List<Integer> nums = new ArrayList<Integer>();
		public void add(int number) {
			//记录所有可能组成的和
			for (int n : nums) {
				sum.add(n + number);
			}
			nums.add(number);
		}
		
		public boolean find(int value) {
			return sum.contains(value);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}















