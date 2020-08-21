package 递归与回溯;

public class 八皇后问题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeQueen(8);
	}
	/*
	 * 数组索引是行号,数组元素是列号, cols[4] = 5 
	 */
	int[] cols;
	
	/*
	 * 从
	 */
	int ways;
	void placeQueen(int n){
		if (n < 1) {
			return;
		}
		cols = new int[n];
		place(0);
		System.out.println(n + "皇后一共有" + ways + "种摆法");
	}
	/*
	 * 从第row行摆放皇后
	 */
	void place(int row) {
		if (row == cols.length) {
			ways++;
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {	//不需要剪枝处理，可以摆放皇后
				//在第row行的第col列摆放皇后
				cols[row] = col;
				
				//马上摆放下一行
				place(row+1);
			}
		}
	}
	
	/*
	 * 判断第row行 第col列是否是可以摆放皇后
	 */
	boolean isValid(int row, int col) {
		for (int i = 0; i < row; i++) {
			//第col列已经有皇后
			if (cols[i]== col) {
				return false;
			}
			//如果斜线上有皇后,
			if (condition) {
				
			}
		}
	}
}














