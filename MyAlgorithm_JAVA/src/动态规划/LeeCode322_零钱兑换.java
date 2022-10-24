package 动态规划;

public class LeeCode322_零钱兑换 {

	/**
	 * 凑到amount所需要的最少的硬币个数
	 * 输入：coins = [1, 2, 5], amount = 11
	 * 输出：3 
	 * 解释：11 = 5 + 5 + 1
	 */
	
	
    public int coinChange(int[] coins, int amount) {
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	int coins(int n) {
		if (n < 1) {
			return Integer.MAX_VALUE;
		}
		if (n == 1 || n == 5 || n == 20 || n == 25) {
			return 1;
		}
		int min1= Math.min(coins(n - 25), coins(n - 20));
		int min2= Math.min(coins(n - 5), coins(n - 1));
		return Math.min(min1, min2) + 1;
 	}

}



















