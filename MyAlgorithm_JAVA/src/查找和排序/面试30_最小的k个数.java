package 查找和排序;

import java.util.Arrays;

public class 面试30_最小的k个数 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 通过快排切分排好第k小的数(下标为k-1), 
	 * 那么它左边的数就是比它小的另外k-1个数
	 */
	public static int[] getLeastNumbers(int[] arr, int k) {
		if (arr.length == 0 || k == 0) {
			return new int[0];
		}
		if (arr.length == k) {
			return arr;
		}
		return quickSearch(arr, 0, arr.length-1, k-1);
	}
	
	public static int[] quickSearch(int[] nums, int low, int high, int k) {
		/*
		 * 每快排切分一次，找到排序后下标为j的元素，
		 * 如果j恰好等于K就返回j左边所有的数
		 */
		int j = partition(nums, low, high);
		if (j == k) {
			return Arrays.copyOf(nums, j+1);
		}
		
		//否则根据下标与k的大小关系来决定继续切分左段还是右段
		return j > k ? quickSearch(nums, low, j-1, k) : quickSearch(nums, j+1, high, k);
	}
	
	
	//一次快排
	public static int partition(int[] nums, int low, int high) {
		int i = low, j = high+1;
		int key = nums[low];
		while (true) {
			//从左到右寻找比Key大的值
			while (nums[++i] < key) {
				if (i == high) {
					break;
				}
			}
			
			//从右到左寻找比Key小的值
			while (nums[--j] > key) {
				if (j == low) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			//i和j交换
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		//与中枢值交换
		//把基准值放到合适的位置
		nums[low] = nums[j];
		nums[j] = key;
		return j;
	}

}
