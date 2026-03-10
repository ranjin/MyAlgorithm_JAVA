package 位运算;

/**
 * 位运算核心逻辑
 * n & (n - 1) 可以消除最后一个1
 */
public class leecode191_位1的个数 {
    public int hammingWeight(int n) {
        int temp = 0;
        while (n != 0) {
            temp += 1;
            n &= (n - 1);
        }
        return temp;
    }
}
