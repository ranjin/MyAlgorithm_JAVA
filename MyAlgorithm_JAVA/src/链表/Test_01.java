package 链表;


public class Test_01 {
	public class ListNodeT {
		int val;
		ListNodeT next;
	}
	
	public static String addBinary(String a, String b) {
        // 先把输入的这两个二进制串反转，低位放在前面，方便处理进位
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(a).reverse().toString();

        // 存储结果
        StringBuilder sb = new StringBuilder();

        int m = a.length(), n = b.length();

        // carry记录进位
        int carry = 0;
        int i = 0, j = 0;

        while (i < m || j < n || carry > 0) {
            int val = carry;
            if (i < m) {
                val += (a.charAt(i) - '0');
                i++;
            }
            if (j < n) {
                val += (b.charAt(j) - '0');
                j++;
            }
            sb.append(val % 2);
            carry = val / 2;
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String aString = "11";
		String bString = "1";
		String ssBuilder = addBinary(aString, bString);
		System.out.println(ssBuilder.toString());
	}

}
