package 动态规划;

public class LeeCode121_买卖股票的最佳时机 {

	/**
	 * 把每一天当作是要卖的那天，计算出每天所能获取的最大利润	
	 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
	 * 输入：[7,1,5,3,6,4]
	 * 输出：5
	 * 表示：1的时候买入，6的时候卖出
	 * 
	 * 
	 * 
	 * 
	 * [7,1,5,3,6,4]
	 *        7
	 * 卖出价：7、1、5、3、6、4
	 * 买入价：	1、1、1、1、1
	 * 利润：		   4、2、5、3
	 */
	/**
	 * 普通思路：
	 * 需要存储动态的最小值；
	 * 需要存储动态的利润最大值；
	 * 需要遍历数组
	 */
    public int maxProfit(int[] prices) {
    	if (prices.length == 0) {
			return 0;
		}
    	// 存储最小值，默认为第一个元素
    	int minValue = prices[0];
    	int maxProfit = 0;
    	for (int i = 1; i < prices.length; i++) {
    		// 比较得出最小值
			minValue = Math.min(minValue, prices[i]);
			// 此时的利润为prices[i] - minValue;
			maxProfit = Math.max(maxProfit, prices[i] - minValue);
		}
    	return maxProfit;
    }
    
    /**
     * 动态规划
     * 第i天买，第j天卖的利润是
     * 第i ～ j天内，所有相邻两天股价差的和
     * 引申出【求最大连续子序列和】的问题
     * 
     * 定义dp(i)为以prices(i)结尾的最大值
     * 
     * 那么
     * 如果 dp(i - 1) <= 0
     * dp(i) = prices[i]
     * 否则
     * dp(i) = dp(i - 1) + prices[i]
     * 
     */
    
//    7、1、5、3、4、6
//    0  1 4  -2 1  2
	  public int maxProfit2(int[] prices) {
		  if (prices.length == 0) {
			return 0;
		  }
		  int[] dp = new int[prices.length];
		  dp[0] = prices[0];
		  int max = dp[0];
		  for (int i = 1; i < prices.length; i++) {
			if (dp[i - 1] <= 0) {
				dp[i] = prices[i];
			} else {
				dp[i] = dp[i - 1] + prices[i];
			}
			max = Math.max(dp[i], max);
		  }
		  return max;
	  }

}
