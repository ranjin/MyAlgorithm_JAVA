package 字符串;

import java.util.Iterator;

/**
 * 实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * 
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 */
public class 字符串压缩 {

    public String compressString(String S) {

    	if (S.length() == 0) {
			return S;
		}

    	StringBuffer res = new StringBuffer();
    	int count = 1;
    	char ss = S.charAt(0);
    	for (int i = 0; i < S.length(); i++) {
			if (ss == S.charAt(i)) {
				count++;
			} else {
				res.append(ss);
				res.append(count);
				ss = S.charAt(i);
				count = 1;
			}
		}
		res.append(ss);
		res.append(count);
    	return res.length() < S.length() ? res.toString() : S; 
    }

}




//if (S.length() == 0) {
//	return S;
//}
//StringBuffer ans = new StringBuffer();
//int count = 1;
//char ch = S.charAt(0);
//for (int i = 1; i < S.length(); i++) {
//	if (ch == S.charAt(i)) {
//		count++;
//	} else {
//		ans.append(ch);
//		ans.append(count);
//		ch = S.charAt(i);
//;				count = 1;
//	}
//}
//ans.append(ch);
//ans.append(count);
//return ans.toString().length() >= S.length() ? S : ans.toString();