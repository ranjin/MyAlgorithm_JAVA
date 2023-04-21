/**
 * 两种思路：
 * 1. 比如最长递归子序列和最大子数组和。思路模版是一个一维的dp数组
 * dp数组的定义是：
 * 在子数组arr[0...i]中，我们要求的子序列的长度是dp[i]
 * 比如：【最长递增子序列】和【最大子数组和】
 */
int n = array.length;
int[] dp = new int[n];
for (int i = 1; i < n; i++) {
    for (int j = 0; j < i; j++) {
        dp[i] = 最值(dp[i], dp[j] + ...)
    }
}

/**
 * 第二种思路：
 * 一个二维的dp数组
 * dp数组的定义如下：
 * 在子数组arr1[0...i]和子数组arr2[0...j]中，我们要求的子序列长度为dp[i][j]
 * 比如：【最长公共子序列】和【编辑距离】
 */

int n = arr.length;
int[][] dp = new dp[n][n];

for (int i = 0; i < n; n++) {
    for (int j = 0; j < n; j++) {
        if (arr[i] == arr[j]) {
            dp[i][j] = dp[i][j] + ...
        } else {
            dp[i][j] = 最值(...)
        }
    }
}