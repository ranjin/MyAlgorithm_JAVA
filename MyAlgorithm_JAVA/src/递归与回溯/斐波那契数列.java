package 递归与回溯;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列：1、1、2、3、5、8、13、21、34、......
 * F(1) = 1、F(1) = 2、F(n) = F(n-1) + F(n-2)(n>=3)
 * @author ran
 *
 */
public class 斐波那契数列 {

	public static void main(String[] args) {
		System.out.println(fib3(3));
	}
	
	/*
	 * 递归方法 
	 * 时间复杂度：2^n
	 * 空间复杂度：O(n)
	 * 
	 * f(n) = f(n-1) + f(n-2)
	 */
	public static int fib0(int n) {
		if (n <= 2) {
			return 1;
		}
		return fib0(n-1) + fib0(n-2);
	}
	
	/**
	 * 备忘录
	 */
	public static int fib4(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		if (n <= 1) {
			return n;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int res = fib4(n - 1) + fib4(n - 2);
		map.put(n, res);
		return res;
	}
	/*
	 * 不使用数组,直接使用两个元素
	 * 时间复杂度: O(N), 空间复杂度:O(1)
	 * f(0) = 0、
	 * f(1) = 1、
	 * f(2) = f(0) + f(1) = 1
	 * f(3) = f(1) + f(2) = 1 + 1 = 2
	 * 1、1、2、3、5、8
	 */
	public static int fib3(int n) {
		if (n <= 2) {
			return 1;
		}
		int first = 1, second = 1;
		for (int i = 3; i <= n; i++) {
			/*
			 * i = 3: second = 2, first = 1
			 * i = 4: second = 3, first = 2
			 * i = 5: second = 5
			 */
			second = first + second;
			first = second - first;
		}
		return second;
	}
}
