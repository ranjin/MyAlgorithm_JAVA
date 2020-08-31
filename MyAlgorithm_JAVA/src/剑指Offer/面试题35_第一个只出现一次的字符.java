package 剑指Offer;

import java.util.HashMap;

public class 面试题35_第一个只出现一次的字符 {

	/*
	 * s = "abaccdeff"
	 * 返回 "b"
	 */
	public char firstUniqChar(String s) {
		HashMap<Character, Boolean> dic = new HashMap<Character, Boolean>();
		char[] sc = s.toCharArray();
		for (char c : sc) {
			dic.put(c, !dic.containsKey(c));
		}
		for (char c : sc) {
			if (dic.get(c)) {
				return c;
			}
		}
		return '';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
