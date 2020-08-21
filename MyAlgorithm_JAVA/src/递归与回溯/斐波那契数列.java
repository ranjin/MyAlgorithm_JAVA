package 递归与回溯;

public class 斐波那契数列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib2(10));
		System.out.println(fib3(10));
	}
	
	/*
	 * fib(n) = fib(n-1) + fib(n-2)
	 */
	public static int fib0(int n) {
		if (n <= 2) {
			return 1;
		}
		return fib0(n-2) + fib0(n-2);
	}
	
	/*
	 * 使用数组优化
	 */
	int fib1(int n) {
		if (n <= 2) {
			return 1;
		}
		int[] array = new int[n+1];
		array[2] = array[1] = 1;
		return fib1(array, n);
	}
	
	int fib1(int[] array, int n) {
		if (array[n] == 0) {
			array[n] = fib1(array, n-1) + fib1(array, n-2);
		}
		return array[n];
	}
	
	/*
	 * 使用【滚动数组】来优化：将数组中的两个元素相加然后替换其中的一个元素
	 * 进一步优化：将取模运算转换成二进制的位运算, 使用与运算
	 */
	public static int fib2(int n) {
		if (n <= 2) {
			return 1;
		}
		int[] arr = new int[2];
		arr[0] = arr[1] = 1;	//最开始的两个元素
		for (int i = 3; i <= n; i++) {
			//超出2了
			arr[i & 1] = arr[(i-1) & 1] + arr[(i-2) & 1];
		}
		return arr[n & 1];
	}
	
	/*
	 * 不使用数组,直接使用两个元素
	 * 时间复杂度: O(N), 空间复杂度:O(1)
	 */
	public static int fib3(int n) {
		if (n <= 2) {
			return 1;
		}
		int first = 1, second = 1;
		for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}

}
