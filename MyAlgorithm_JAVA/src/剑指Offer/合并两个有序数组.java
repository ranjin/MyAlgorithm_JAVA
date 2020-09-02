package 剑指Offer;

public class 合并两个有序数组 {

	//三指针
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = m - 1;
		int i2 = n - 1;
		int cur = nums1.length - 1;
		while (i2 >= 0) {
			if (i1 >= 0 && nums1[i1] > nums2[i2]) {
				nums1[cur] = nums1[i1];
				i1--;
				cur--;
			}else {
				nums1[cur] = nums2[i2];
				cur--;
				i2--;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
