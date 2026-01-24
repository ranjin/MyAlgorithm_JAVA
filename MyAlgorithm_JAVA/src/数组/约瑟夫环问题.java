package 数组;

/**
 * n个人（编号0~n-1）围成一圈，从0号人开始报数（从1开始），报到m的人退出，后面的人继续从1开始报数，问，最后剩下的一个人是几号
 * 
 * 经典约瑟夫问题：
 * n = 1时，编号为0。幸存者是自己
 * n > 1时，f((n - 1), m) mod n
 */

public class 约瑟夫环问题 {

	public static int getJosephusPosition(int n, int m) {
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = (result + m) % i;
		}
		return result;
	}
}
