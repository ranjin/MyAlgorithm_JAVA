package LeeCode;

public class Test {
	/*
	 * [-2,1,-3,4,-1,2,1,-5,4]
	 */
    public static int maxSubArray(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
    	int res = 0;
    	for (int i = 0; i < nums.length; i++) {
			nums[i] += Math.max(nums[i-1], 0);
			res = Math.max(res, nums[i]);
		}
    	return res;
    }
    
    public static void main(String[] args) {
		int[] num = {-2,1};
		System.out.println(maxSubArray(num));
	}
}
