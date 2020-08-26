package 剑指Offer;

public class 二进制中1的个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingWeight(int n) {
		int result = 0;
		while (n >= 0) {
			n = n & (n - 1);
			return++;
		}
		return result;
	}

}
