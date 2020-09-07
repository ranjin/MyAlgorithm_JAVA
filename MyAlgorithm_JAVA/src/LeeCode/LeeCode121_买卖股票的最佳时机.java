package LeeCode;

public class LeeCode121_买卖股票的最佳时机 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int maxProfit(int[] prices) {
		  int n = prices.length;
		  int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		  for (int i = 0; i < n; i++) {
			  dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			
			  dp_i_1 = Math.max(dp_i_1, -prices[i]);
			  }
		  return dp_i_0;
	  }

}
