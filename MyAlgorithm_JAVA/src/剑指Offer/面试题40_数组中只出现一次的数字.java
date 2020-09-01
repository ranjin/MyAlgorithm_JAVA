package 剑指Offer;

public class 面试题40_数组中只出现一次的数字 {

	/*
	 * 输入：nums = [4,1,4,6]
	 * 输出：[1,6] 或 [6,1]
	 */
	
	public int[] singleNumbers(int[] nums) {
		//用于将所有的数异或起来
		int k = 0;
		for (int i : nums) {
			k ^= i;
		}
		
		//获得k中最低位的1
		int mask = 1;
		
		while ((k & mask) == 0) {
			mask <<= 1;
			
		}
		int a = 0;
		int b = 0;
		for (int num : nums) {
			if ((num & mask) == 0) {
				//偶数
				a ^= num;
			}else {
				b ^= num;
			}
		}
		return new int[] {a, b};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
