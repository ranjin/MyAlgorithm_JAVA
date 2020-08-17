import java.util.Arrays;
import java.util.Scanner;

/*
 * 按位异或：相同为0
 * length：num.length
 * 
 */
public class 缺失数字 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		String[] inputStrings = inputString.split(",");
		int[] nums = new int[inputString.length()];
		int n = missingNumber(nums);
		System.out.println(n);
	}
	
//	public static int missingNumber(int[] nums) {
//		Arrays.sort(nums);
//		
//		//判断是不是在0与末尾处
//		if (nums[0] != 0) {
//			return 0;
//		}
//		if (nums[nums.length - 1] != nums.length) {
//			return nums.length;
//		}
//		for (int i = 1; i < nums.length; i++) {
//			int expectedNum = nums[i-1] + 1;
//			if (expectedNum != nums[i]) {
//				return expectedNum;
//			}
//		}
//		return -1;
//	}
	
	//按位异或
	public static int missingNumber(int[] nums) {
		int length = nums.length;
		int missing = 0;
		for (int i = 0; i < length; i++) {
			missing = length ^(i^nums[i]);
		}
		return missing;
	}

}
