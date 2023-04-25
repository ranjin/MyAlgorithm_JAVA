package 数组;

import java.util.LinkedList;

public class testDemo {
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
