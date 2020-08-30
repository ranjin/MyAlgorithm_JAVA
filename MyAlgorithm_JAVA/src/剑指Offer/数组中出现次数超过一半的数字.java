package 剑指Offer;

public class 数组中出现次数超过一半的数字 {

	/*
	 * 在遍历数组的时候保存两个值：
	 * 一个是数组中的一个数字，一个是次数。
	 */
    public int majorityElement(int[] nums){
    	if (nums.length == 0) {
    		return -1;
		}
    	int result = nums[0];
    	int times = 1;
    	for (int i = 0; i < nums.length; i++) {
			if (times == 0) {
				result = nums[i];
				times = 1;
			}else if (nums[i] == result) {
				times++;
			}else {
				times--;
			}
		}
    	return result;
    }
  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
