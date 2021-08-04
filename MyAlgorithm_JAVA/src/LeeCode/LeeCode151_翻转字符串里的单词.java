package LeeCode;

import java.awt.color.ColorSpace;
import java.awt.desktop.PrintFilesEvent;
import java.util.Iterator;

/**
 * 
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * @author ran
 *
 */
public class LeeCode151_翻转字符串里的单词 {

	/**
	 * 将[li, ri)范围内的字符串进行逆序
	 * @param chars
	 * @param li
	 * @param ri
	 */
	public static void reverse(char[] chars, int li, int ri) {
		ri--;
		while (li < ri) {
			char temp = chars[li];
			chars[li] = chars[ri];
			chars[ri] = temp;
			li++;
			ri--;
		}
	}
    public String reverseWords(String s) {
    	if (s == null) {
			return null;
		}
    	char[] chars = s.toCharArray();
    	
    	// 清除多余的空格
    	// 字符串最终的有效长度
    	int len = 0;
    	
    	// 当前用来存放字符的位置
    	int cur = 0;
    	
    	/**
    	 * 判断前面的字符是不是空格字符
    	 * 可以看作是第-1个为空格，所以如果第一个为空格，直接跳过
    	 */
    	boolean space = true; 
     	
    	for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				chars[cur] = chars[i];
				cur++;
				space = false;
			} else if(space == false) {
				// chars[i]是空格字符，char[i-1]是非空格字符
				chars[cur] = ' ';
				cur++;
				space = true;
			} else {
				// 多个空格 ，直接跳过 i++
			}
		}
    	
    	len = space ? cur - 1 : cur;
    	
    	// 对整个字符串进行逆序
    	reverse(chars, 0, len);
    	
    	/**
    	 * 对每一个单词进行逆序
    	 */
    	int prevSpaceIdx = -1;
    	for (int i = 0; i < len; i++) {
			if (chars[i] != ' ') {
				continue;
			}
			// i是空格字符的位置 左闭右开
			reverse(chars, prevSpaceIdx+1, i);
			prevSpaceIdx = i;
		}
    	// 翻转最后一个字符串
    	reverse(chars, prevSpaceIdx+1, len);
    	return new String(chars, 0, len);
    }
}
