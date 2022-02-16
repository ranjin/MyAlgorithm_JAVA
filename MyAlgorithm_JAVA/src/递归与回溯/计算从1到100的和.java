package 递归与回溯;

// 使用递归不是为了求得最优解，是为了简化解决问题的思路
/**
 * 求1+2+3+4+...+(n-1)+n的和(n>0)
 * @author ran
 *
 */
public class 计算从1到100的和 {
	/**
	 * 递归方法: 时间复杂度O(n), 空间复杂度O(n)
	 */
	int sum(int n) {
		if (n <= 1) {
			return 1;
		}
		return n + sum(n-1);
	}
	
	/**
	 * 非递归方式: 时间复杂度O(n), 空间复杂度O(1)
	 */
	int sum2(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += i;
		}
		return result;
	}
	
	/**
	 * 时间复杂度O(1), 空间复杂度O(1)
	 */
	int sum3(int n) {
		if (n <= 1) {
			return n;
		}
		return n*(n-1) >> 2;
	}
}
