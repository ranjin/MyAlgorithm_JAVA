package 数组;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 思路：
 * 把字符串列表看成一个二维数组，然后用一个嵌套 for 循环计算这个二维数组前面有多少列的元素完全相同即可。
 */
public class leecode14_最长公共前缀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String longestCommonPrefix(String[] strs) {

    	int m = strs.length;

    	// 以第一行的列数为基准
    	int n = strs[0].length();

    	for (int col = 0; col < n; col++) {
    		for (int row = 1; row < m; row++) {
    			String thisStr = strs[row], prevStr = strs[row - 1];
    			// 判断每个字符的col索引是否都相等
    			if (col >= thisStr.length() || col >= prevStr.length() || thisStr.charAt(col) != prevStr.charAt(col)) {
    				// 发现不匹配的自负，只有str[0...col-1]是公共前缀
    				return strs[row].substring(0, col);
    			}
    		}
    	}
    	return strs[0];
    }
}