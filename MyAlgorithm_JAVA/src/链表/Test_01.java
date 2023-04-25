package 链表;


public class Test_01 {
	public class ListNodeT {
		int val;
		ListNodeT next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, -5, 3, -2, 4, -3, -5, -2, 6};
		
		// sums = [1, -4, -1, -3, 1, -2, -7, -9, -3]
		
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
			System.out.println(sums[i]);
		}
	}

}
