package 动态规划;

import java.util.Iterator;

/**
 * 子串是连续的子序列
 * ABCBA和BABCA的最长公共子串是ABC，长度为3  
 *
 * 定义状态：
 * 假设dp(i)(j)是以str1[i-1]、str2[j-1]结尾的最长公共子串长度
 * 
 * 初始状态:
 * dp(i,0)、dp(0,j)的值均为0
 * 
 * 状态转移方程：
 * 
 * 
 * 思路：
 * A B C D
 *     =
 * B A B C
 *       =
 *       
 * 如果str1[i] = str2[j],看前面的是否相等，即：str1[i-1] str2[i-2]
 * 
 */
public class 最长公共子串 {

	public void main(String[] args) {
		System.out.println(lcs("ABDCBA", "EGH"));
	}
	
	// 
	static int lcs(String str1,  String str2) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		char[] chars1 = str1.toCharArray();
		if (chars1.length == 0) {
			return 0;
		}
		char[] chars2 = str2.toCharArray();
		if (chars2.length == 0) {
			return 0;
		}
		// 初始值均为0
		
		// i: 1 - length  j: 1 - length
		int[][] dp = new int[chars1.length + 1][chars2.length + 1];
		int max = 0;
		for (int i = 1; i <= chars1.length; i++) {
			for (int j = 1; j <= chars2.length; j++) {
				if (chars1[i - 1] != chars2[j - 1]) {
					continue;
				}
				// 直接设置dp[i][j]
				dp[i][j] = dp[i - 1][j - 1] + 1;
				max = Math.max(dp[i][j], max);
			}
			
		}
		return max;
	}
	
	
	// 使用一维数组进行优化
	static int lcs2(String str1,  String str2) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		char[] chars1 = str1.toCharArray();
		if (chars1.length == 0) {
			return 0;
		}
		char[] chars2 = str2.toCharArray();
		if (chars2.length == 0) {
			return 0;
		}
		// 初始值均为0 短的作为行，长的作为列
		char[] rowsChars = chars1, colsChars = chars2;
		if (chars1.length < chars2.length) {
			colsChars = chars1;
			rowsChars = chars2;
		}
		
		// i: 1 - length  j: 1 - length
		int[] dp = new int[colsChars.length + 1];
		int max = 0;
		for (int row = 1; row <= rowsChars.length; row++) {
			for (int col = 1; col <= colsChars.length; col++) {
				if (chars1[row - 1] != chars2[col - 1]) {
					continue;
				}
				// 直接设置dp[i][j]
				dp[col] = dp[col - 1] + 1;
				max = Math.max(dp[col], max);
			}
		}
		return max;
	}
}













