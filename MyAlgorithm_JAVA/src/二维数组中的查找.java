
public class 二维数组中的查找 {

	/*
	 * 不能选择左上角和右下角，这样无法直接剔除行或者列，而且时间复杂度也会增加。
	 * 考虑从右上或者左下入手
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Boolean findNumberIn2DArray(int[][] matrix, int target) {
		boolean found = false;
		int rows = matrix.length, colums = matrix[0].length;
		if (matrix != null && rows > 0 && colums > 0) {
			//从右上开始，第0行的最后一列
			int row = 0, column = colums-1;
			while (row < rows && column >= 0) {
				if (matrix[row][column] == target) {
					found = true;
					break;
				}else if (matrix[row][column] > target) {
					column--;
				}else if (matrix[row][column] < target) {
					row++;
				}
			}
		}
		return found;
	}
}
