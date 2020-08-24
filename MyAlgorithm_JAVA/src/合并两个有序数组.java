
public class 合并两个有序数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 两个指针 指向两个数组的最后一个元素开始比较，然后用第三个指针指向放值的地方
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/*
		 * 初始化三个指针
		 */
		int i1 = m-1;
		int i2 = n-1;
		int cur = nums1.length-1;
		while (i2 >= 0) {
			if (i1 >= 0 && nums1[i1] > nums2[i2]) {
				nums1[cur] = nums1[i1];
				cur--;
				i1--;
			}else{
				nums1[cur] = nums2[i2];
				cur--;
				i2--;
			}
		}
	}
}
