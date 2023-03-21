package 形式1_元素无重不可复选;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数n和k，返回范围[1, n]中所有可能的k个数的组合。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 思路：
 * 其实就是所有大小为k的子集,根据回溯树，即第k层的子节点的个数。 
 */
public class leecode77_组合 {
	List<List<Integer>> res = new LinkedList<>();
	// 记录回溯算法的递归路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// i从1开始是因为题目要求中的[1, n]
    public List<List<Integer>> combine(int n, int k) {
    	backtrack(1, n, k);
    	return res;
    }
    
    public void backtrack(int start, int n, int k) {
		if (k == track.size()) {
			res.add(new LinkedList<>(track));
			return;
		}
		// 回溯算法标准框架
		for (int i = start; i <= n; i++) {
			track.addLast(i);
			backtrack(i + 1, n, k);
			track.removeLast();
		}
	}
}
