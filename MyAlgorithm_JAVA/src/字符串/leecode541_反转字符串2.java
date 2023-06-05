package 字符串;

public class leecode541_反转字符串2 {

	/**
	 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
	 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
	 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
	 * 
	 * 输入：s = "abcdefg", k = 2
	 * 输出："bacdfeg"
	 * 
	 * 输入：s = "abcd", k = 2
	 * 输出："bacd"
	 */
	
    public static String reverseStr(String s, int k) {

    	
    	char[] charArr = s.toCharArray();
    	int n = charArr.length;	//	n = 7, k = 2
    	
    	// 每次便利的索引
    	int index = 0;
    	
    	// 循环，直至最后的个数小于k个
    	while ((n - index) > 2 * k) {
    		reverse(charArr, index, index + 2 * k - 1);
    		
    		index += (2 * k);
		}
    	
    	if ((n - index) < k) {
        	reverse(charArr, index, n-1);
		}
    	
    	
    	return String.valueOf(charArr);

    	
    }
    
    // 单次遍历字符替换
    public static void reverse(char[] s, int start, int end) {
    	if (end) {
			
		}
    	int newEnd = end / 2;
    	while (start <= newEnd) {
			char temp = s[start];
			s[start] = s[newEnd];
			s[newEnd] = temp;
			start++;
			newEnd--;
		}
    }
    
	public static void main(String[] args) {
		String string = "abcedfg";
		reverseStr(string, 2);
	}

}
