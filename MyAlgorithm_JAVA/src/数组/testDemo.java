package 数组;


public class testDemo {
	
	
	/**
	 * 
	 * 输入：nums = [0,	0,	1,	1,	1,	2,	2,	3,	3,	4]
	 * 输出：5, nums = [0,1,2,3,4]
	 * 
	 */
    public int removeDuplicates(int[] nums) {

        //
        int n = nums.length;
        if (n <= 1) {
        	return n;
        }
        int slow = 0, fast = 1;
        while (fast < n) {
			if (nums[slow] == nums[fast]) {
				fast++;
			} else {
				slow++;
				nums[slow] = nums[fast];
				fast++;
			}
		}
        return slow + 1;
        
        

    }
	public static int[] mergeTwoArr(int[] nums1, int[] nums2) {
		int l1 = nums1.length, l2 = nums2.length;
		int[] resultArr = new int[l1 + l2];
				
		int index1 = 0, index2 = 0;
		for (int i = 0; i < resultArr.length; i++) {
			if (index1 < l1 && index2 < l2 ) {
				if (nums1[index1] < nums2[index2]) {
					resultArr[i] = nums1[index1];
					index1++;
				} else {
					resultArr[i] = nums2[index2];
					index2++;
				}
			} else {
				if (index1 >= l1) {
					resultArr[i] = nums2[index2];
					index2++;
				} else if (index2 >= l2) {
					resultArr[i] = nums2[index1];
					index1++;
				}
			}
		}
		return resultArr;
	}
	// 合并两个有序数组
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[]{1, 3, 8, 9};
		int[] nums2 = new int[]{2, 5, 10, 13};

		
		
		// 合并函数
		int[] ss = mergeTwoArr(nums1, nums2);
//		System.out.println(mergeTwoArr(nums1, nums2));
		System.out.println(ss);

	}

	
	

}
