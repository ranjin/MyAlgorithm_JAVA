import java.util.Scanner;

public class 获的最多的奖金 {

	/*
	 * 前缀和数组求解:
	 * preSum[i] 就是num[0...i-1]的和
	 * preSum[i...j] 就是preSum[j+1] - preSum[i]
	 */
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		long[] input = new long[n];
//		int[] arr = {1,3,4,5,6,1,4,6};
//		int n1 = bouns(4, arr);
//	}
	
	/*
	 * 双指针求解
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] input = new long[n];
		for (int i = 0; i < input.length; i++) {
			input[i] = scanner.nextInt();
		}
		long ans = 0;
		int left = 0;
		int right = n-1;
		long suml = input[left], sumr = input[right];
		while (left < right) {
			if (suml == sumr) {
				ans = suml;
				suml += input[left];
				sumr += input[right];
				left++;
				right--;
			}else if (suml > sumr) {
				sumr += input[right];
				right--;
			}else if (suml < sumr) {
				suml += input[left];
				left++;
			}
		}
		System.out.println(ans);
	}
	public static int bouns(int k, int nums[]) {
		int ans = 0;
		//创建前缀和数组
		int n = nums.length;
		int[] preSum = new int[n+1];
		preSum[0] = 0;
		for (int i = 0; i < n; i++) {
			preSum[i+1] = preSum[i]+nums[i];
		}
		
		/*
		 * num[1...i]的和就是 preSum[i+1]的值
		 * 
		 * num[j...n]的和就是preSum[n+1]-preSum[j]
		 */
		//打印前缀和数组
		for (int i : preSum) {
			System.out.print(i + " ");
		}
		

		//presSum[j...n]
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (preSum[n+1] - preSum[j] == preSum[i+1]) {
					System.out.print(preSum[i+1]);
					return preSum[i+1];
				}
			}
		}
		return 0;
	}

}
