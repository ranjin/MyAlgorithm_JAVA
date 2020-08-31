package 剑指Offer;

public class 面试题34_丑数 {

	public static int GetUglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}
		int number = 0;
		int uglyFound = 0;
		while (uglyFound < index) {
			++number;
			if (IsUgly(number)) {
				++uglyFound;
			}
		}
		return number;
	}
	//判断一个数是否是丑数
	public static boolean IsUgly(int number) {
		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return number == 1 ? true : false;
	}
	public static void main(String[] args) {
		System.out.println(GetUglyNumber(1500));
	}

}
