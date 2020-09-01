package 剑指Offer;

import java.util.ArrayList;

public class 面试题41_2_和为S的连续正数序列 {

	/*
	 * 初始化small为1与big为2
	 * 序列和 < target big++
	 * 序列和 > target small++
	 * 
	 * 序列和 == target big++
	 */
    public int[][] findContinuousSequence(int target) {
    	ArrayList<int[]> results = new ArrayList<int[]>();
    	int small = 1, big = 2;
    	int curSum = small + big;
    	while (small <= target/2) {
			if (curSum == target) {
				int[] result = new int[big-small+1];
				for (int k = 0; k < result.length; k++) {
					result[k] = small + k;
				}
				results.add(result);
				curSum -= small++;
			}else if (curSum > target) {
				curSum -= small++;
			}else {
				curSum += ++big;
			}
		}
    	return results.toArray(new int[results.size()][]);
    	
    }
}










