package LeeCode;

public class LeeCode165_比较版本号 {

	public static void main(String[] args) {		
		String version1 = "1.01.23";
		String version2 = "1.001";
		int result = compareVersion(version1, version2);
		System.out.println(result);
	}
	
	//要注意转义字符：“.”和“|”都是转义字符，必须得加"\\"
    public static int compareVersion(String version1, String version2) {
    	String[] nums1 = version1.split("\\.");
    	String[] nums2 = version2.split("\\.");
    	int n1 = nums1.length;
    	int n2 = nums2.length;
    	int i1, i2;
    	//获取最大索引，不足填0
    	for (int i = 0; i < Math.max(n1, n2); i++) {
			i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
			i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
			if (i1 != i2) {
				return i1 > i2 ? 1 : -1;
			}
		}
    	return 0;
	}
}







