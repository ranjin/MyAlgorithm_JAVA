package 剑指Offer;

public class 面试题45_把数组排成最小的数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * [3、30、34、5、9]
	 */
	
	public String minNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		fastSort(strs, 0, strs.length-1);
		StringBuilder res = new StringBuilder();
		for (String s : strs) {
			res.append(s);
		}
		return res.toString();
	}
	void fastSort(String[] strs, int low, int high) {
		if (low >= high) {
			return;
		}
		int i = low, j = high + 1;
		String key = strs[low];
		while (i < j) {
			while ((strs[j] + strs[low]).compareTo(strs[low] + strs[j]) >= 0 && i < j){
				j--;
			} 
			while ((strs[i] + strs[high]).compareTo(strs[high] + strs[i]) <= 0 && i < j){
				j--;
			} 
			key = strs[i];
			strs[i] = strs[j];
			strs[j] = key;
		}
		strs[i] = strs[low];
		strs[low] = key;
		fastSort(strs, low, i-1);
		fastSort(strs, i + 1, high);
	}

}
