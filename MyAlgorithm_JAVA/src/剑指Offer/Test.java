package 剑指Offer;

import java.util.HashMap;

public class Test {

	/*
	 * HashMap:
	 * key : value
	 * 2	 1
	 * 7	 2
	 * 11	 3
	 * 15	 4
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] sums, int target) {
		if (sums.length == 0) {
			return new int[] {0, 0};
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < sums.length; i++) {
			//key为数值，value为索引
			map.put(sums[i], i);
		}
		for (int i = 0; i < sums.length; i++) {
			int remainNo = target - sums[i];
			if (map.containsKey(remainNo)) {
				return new int[] {i, map.get(remainNo)};
			}
		}
	}

}











