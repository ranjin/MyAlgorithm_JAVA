package 递归与回溯;

/*
 * 楼梯有n阶台阶，上楼可以一步走1阶，也可以一步上2阶，走完n阶台阶共有多少种不同的走法？
 * 假设n阶台阶有f(n)种走法，第1步有2种走法
 * 如果上1阶，那就还剩n-1阶，共f(n-1)种走法
 * 如果上2阶，那就还剩n-2阶，共f(n-2)种走法
 * 所以f(n) = f(n-1) + f(n-2)
 */
public class 爬楼梯 {

	public static void main(String[] args) {
		
	}
	
	public static int clibmStarirs(int n) {
		if (n <= 2) {
			return n;
		}
		return clibmStarirs(n-1) + clibmStarirs(n-2);
	}
	
	/**
	 * 类似斐波那契数列的优化
	 */
	public static int clibmStarirs2(int n) {
		int first = 1, second = 2;
		for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
}
