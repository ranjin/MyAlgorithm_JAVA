package 剑指Offer;

/*
 * 旋转数组的最小数字
 */
public class MinArray_11 {

//	public int minArray(int[] numbers) {
//		for (int j = 1; j < numbers.length; j++) {
//			if (numbers[j] < numbers[0]) {
//				return numbers[j];
//			}
//		}
//		return numbers[0];
//	}
	/*
	 * 思路2:采用二分查找的方式
	 */
	
	public int minArray(int[] numbers) {
		if (numbers.length == 0) {
			return -1;
		}
		//最前与最后的索引下标
		int i1 = 0, i2 = numbers.length-1;
		int midIndex = i1;
		while (numbers[i1] >= numbers[i2]) {
			if (i2 - i1 == 1) {
				midIndex = i2;
				break;
			}
			midIndex = (i1 + i2) / 2;
			if (numbers[i1] == numbers[i2] && numbers[i1] == numbers[midIndex]) {
				//顺序查找
				return miniOrder(numbers, i1, i2);
			}
			if (numbers[midIndex] >= numbers[i1]) {
				//3、4、5、1、2
				i1 = midIndex;
			}else if (numbers[midIndex] <= numbers[i2]) {
				i2 = midIndex;
			}
			return numbers[midIndex];
		}
	}
	
	public int miniOrder(int[] numbers, int index1, int index2) {
		int result = numbers[index1];
		for (int i = index1+1; i < index2; i++) {
			if (result > numbers[i]) {
				return numbers[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}