package 剑指Offer;

public class 数值的整数次方_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double Power(double base, int exponent) {
		int result = 0;
		for (int j = 0; j < exponent; j++) {
			result *= base;
		}
		return result;
	}
}
