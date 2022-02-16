
package 递归与回溯;

/*
 * 把A的n个盘子移动到C
 * 每次只能移动一个盘子
 * 大的盘子只能放在小盘子下面
 */
public class 汉诺塔 {

	public static void main(String[] args) {
		new 汉诺塔().hanoi(3, "A", "B", "C");
	}
	
	/*
	 * 分两种情况
	 * 当n=1，直接将盘子从A移动到C
	 * 当n>1，可以拆分成3大步骤：
	 * 将n-1个盘子从A移动到B
	 * 将编号为n的盘子从A移动到C
	 * 将n-1个盘子从B移动到C
	 * 时间复杂度：O(2^n)
	 * 空间复杂度：O(N)
	 */
	void hanoi(int n, String A, String B, String C) {
		// 递归基
		if (n == 1) {
			move(1, A, C);
			return;
		}
		hanoi(n-1, A, C, B);	//将n-1个盘子从A移动到B
		move(n, A, C);			//将第n个盘子从A移动到C
		hanoi(n-1, B, A, C);	//将n-1个盘子从B移动到C
	}
	void move(int no, String from, String to) {
		System.out.println("将" + no + "号盘子从" + from + "移动到" + to);
	}

}
