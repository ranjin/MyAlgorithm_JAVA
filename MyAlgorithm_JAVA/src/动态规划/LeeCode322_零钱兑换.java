package 动态规划;

public class LeeCode322_零钱兑换 {

	/**
	 * 凑到amount所需要的最少的硬币个数
	 * 输入：coins = [1, 2, 5], amount = 11
	 * 输出：3 
	 * 解释：11 = 5 + 5 + 1
	 */
	
	
    public int coinChange(int[] coins, int amount) {
    	return dp(coins, amount);
    }
    
	// dp定义：要凑出金额n，至少要dp(coins, n)个硬币
	int dp(int[] coins, int amount) {
		// base case
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		int res = Integer.MAX_VALUE;
		for (int coin : coins) {
			// 计算字问题的结果
			int subProblem = dp(coins, amount - coin);
			// 子问题无解则跳过
			if (subProblem == -1) {
				continue;
			}
			// 在子问题中选择最优解，然后加1
			res = Math.min(res, subProblem + 1);
		}
		return res = (res == Integer.MAX_VALUE) ? -1 : res;
 	}
}



















