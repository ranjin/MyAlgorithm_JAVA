package 剑指Offer;

public class 调整数组顺序使奇数位于偶数前面 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void ReorderOddEvent(int[] data, int length) {
		if (data.length == 0) {
			return;
		}
		//初始化两个指针的位置，左指针直到遇到偶数，右指针直到遇到奇数
		int i = 0, j = data.length-1;
		while (i < j) {
			while (i < j && (data[i] & 1) != 0) {
				//如果i < j && data[i]为奇数
				i++;
			}
			while (i < j && (data[j] & 1) == 0) {
				//如果i < j && data[j]为偶数
				j--;
			}
			if (i < j) {
				data[i] = data[i] + data[j];
				data[j] = data[i] - data[j];
				data[i] = data[i] - data[j];
			}
		}
	}
	
	/*
	 * 扩展性更好的解法
	 */
	public void ReorderOddEvent2(int[] data, int length, boolean isSatified) {
		if (data.length == 0) {
			return;
		}
		//初始化两个指针的位置，左指针直到遇到偶数，右指针直到遇到奇数
		int i = 0, j = data.length-1;
		while (i < j) {
			while (i < j && !isSatified) {
				//如果i < j && data[i]为奇数
				i++;
			}
			while (i < j && isSatified) {
				//如果i < j && data[j]为偶数
				j--;
			}
			if (i < j) {
				data[i] = data[i] + data[j];
				data[j] = data[i] - data[j];
				data[i] = data[i] - data[j];
			}
		}
	}
	
	//扩展函数
	public boolean isSatified(int n) {
		return (n & 1) == 0;
	}

}














