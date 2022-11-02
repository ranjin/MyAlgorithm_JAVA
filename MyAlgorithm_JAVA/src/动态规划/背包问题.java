package 动态规划;

/**
 * n件物品，最大承重为W
 * 每件物品的重量是Wi、价值是Vi
 * 在总重量 <= W的前提下，选择一些物品装入背包，那么背包的最大总价值可以达到多少？
 * 注意：每个物品只有1件，也就是每个物品只能选择0件或者1件
 *
 * 事例：
 * 最大承重是10，
 * 价值：6、3、5、4、6
 * 重量：2、2、6、5、4
 * 状态定义：
 * values是价值数组，weights是重量数组
 * 
 * 🌟🌟：状态定义与问题结果描述有关。
 * dp(i,j)表示最大承重为j，有前i件物品可以选时的最大价值
 * 
 * 状态初始值：
 * dp(i,0)与dp(0,j)初始值均为0 根据状态定义，表示最大承重为0，或者有前0件物品可以选择时的最大价值
 * 
 * 状态转移方程：
 * dp(i, j)表示最大承重为j,有前i件物品可以选择的时候
 * 
 * 如果j < weights[i-1],表示：背包的最大承重 < 最后一件物品的重量.dp(i,j) = dp(i-1,j)
 * 如果不选择第i件物品：则dp(i,j) = dp(i - 1,j.表示最大承重不变，但是价格不包括第i件，为前面i-1件的
 * 如果选择第i件物品：则dp(i,j) = dp(i-1, j - weights[i-1]) + values[i-1]
 * 
 */
public class 背包问题 {
	static int maxValue(int[] values, int[] weights, int capacity) {
		if (values == null || values.length == 0) {
			return 0;
		}
		if (weights == null || weights.length == 0) {
			return 0;
		}
		if (values.length != weights.length || capacity <= 0) {
			return 0;
		}
		
		// i: 物品数量。j：最大承重
		int[][] dp = new int[values.length + 1][capacity + 1];
		for (int i = 1; i <= values.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weights[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					// 不选或者选择
					dp[i][j] = Math.max(
							dp[i - 1][j], 
							dp[i - 1][j - weights[i-1]] + values[i - 1]);
				}
			}
		}
		return dp[values.length][capacity];
	}
}






















