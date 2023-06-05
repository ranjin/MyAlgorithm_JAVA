package 字符串;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */

/**
 * java 字符串常用函数
 * 
 * 1. substring: 截取函数
 * substring(int endIndex)
 * substring(int startIndex, int endIndex)
 * 
 * 2. concat: 连接两个字符串
 * 
 * 3. replace: 替换函数，例如：String s=”Hello”.replace(’l',’w');
 * 
 * 4. trim: 去掉开头与结尾的空格
 * 
 * 5. charAt: 截取一个字符
 * 
 *
 */
public class 剑指offer58_左旋转字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public String reverseLeftWords(String s, int n) {
    	return s.substring(n) + s.substring(0, n);
    }
}
