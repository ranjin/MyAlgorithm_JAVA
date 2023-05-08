package 滑动窗口;

import java.util.HashMap;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * 
 * 思路：使用滑动窗口
 * 什么时候应该扩大窗口 ? 当可替换次数 >= 0时，扩大窗口，让进入窗口的0都变为1，使得连续的1的长度尽可能大。
 * 什么时候应该缩小窗口 ? 当可替换次数 < 0时，缩小窗口，空余出可替换次数，以便继续扩大窗口
 * 什么时候得到一个合法的答案 ?
 * 
 *
 */
public class leecode1004_最大连续1的个数3 {

    public int longestOnes(int[] nums, int k) {
    	HashMap<Integer, Integer> window = new HashMap<>();
    	
    	int left = 0, right = 0;
    	
    	// 记录窗口中1的出现次数
    	int windowOneCount = 0;
    	
    	// 记录结果长度
    	int res = 0;
    	
    	while (right < nums.length) {
			if(nums[right] == 1) {
				windowOneCount++;
			} 
			right++;
			
			// 缩小窗口 当窗口中需要替换的0的数量大于k,缩小窗口
			while (right - left - windowOneCount > k ) {
				if (nums[left] == 1) {
					windowOneCount--;
				}
				left++;
			}
			// 此时一定是一个合法的窗口
			res = Math.max(res, right - left);
		}
    	return res;
    }
}
