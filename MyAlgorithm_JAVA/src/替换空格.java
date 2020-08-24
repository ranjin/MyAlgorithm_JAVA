
public class 替换空格 {

	/*
	 * 思路：先遍历获取字符串的长度，计算需要返回的字符串的新长度。
	 * 然后
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer ssBuffer = new StringBuffer("Hello World");
		String ssString = replaceSpace(ssBuffer);
		System.out.println(ssString);
	}

	public static String replaceSpace(StringBuffer str) {
		StringBuilder reStringBuilder = new StringBuilder();
		for (char c : str.toString().toCharArray()) {
			if (c == ' ') {
				reStringBuilder.append("%20");
			}else {
				reStringBuilder.append(c);
			}
		}
		return reStringBuilder.toString();
	}
	/*
	 * 存在越界的情况
	 */
//	public static String replaceSpace(StringBuffer str) {
//		String ss = str.toString();
//		char[] charStr = ss.toCharArray();
//		int length = charStr.length;
//		if (str == null || length <= 0) {
//			return ss;
//		}
//		/*
//		 * originalLength为字符串str的实际长度
//		 */
//		int originalLength = 0;
//		int numberOfBlank = 0;
//		int i = 0;
//		while (i < length) {
//			originalLength++;
//			if (charStr[i] == ' ') {
//				numberOfBlank++;
//			}
//			i++;
//		}
//		
//		/*
//		 * newLength为把空格替换成'%20'之后的长度
//		 */
//		int newLength = originalLength + numberOfBlank * 2;
//
//		//从后往前 初始化两个指针的位置 - 分别是两个字符串最后的索引位置
//		int indexOfOriginal = originalLength;
//		int indexOfNew = newLength;
//		while (indexOfOriginal >= 0 && indexOfNew > originalLength) {
//			if (charStr[indexOfOriginal] == ' ') {
////				charStr[indexOfNew--] = '0';
////				charStr[indexOfNew--] = '2';
////				charStr[indexOfNew--] = '%';
//				charStr[indexOfNew] = '0';
//				indexOfNew--;
//				charStr[indexOfNew] = '2';
//				indexOfNew--;
//				charStr[indexOfNew] = '%';
//				indexOfNew--;
//			}else {
//				charStr[indexOfNew] = charStr[indexOfOriginal];
//				indexOfNew--;
//			}
//			indexOfOriginal--;
//		}
//		return charStr.toString();
//	}
	
}
