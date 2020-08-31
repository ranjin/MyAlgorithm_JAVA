package 剑指Offer;

public class 面试题32_从1到n整数中1出现的次数 {

	/*
	 * 输入一个整数n。
	 * 那么从1-12这些整数中包含1的数字有1、10、11、12
	 * 1出现的次数一共有5次。
	 */
	public int countDigitOne(int n) {
		int totalCount = 0;
		for (int i = 1; i <= n; i++) {
			totalCount += getSingleNum(i);
		}
		return totalCount;
	}
	
	public static int getSingleNum(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 10 == 1) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
