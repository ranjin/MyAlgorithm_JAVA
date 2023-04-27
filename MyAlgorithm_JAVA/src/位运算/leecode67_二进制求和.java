package 位运算;

public class leecode67_二进制求和  {
	public static String addBinary(String a, String b) {
        // 先把输入的这两个二进制串反转，低位放在前面，方便处理进位
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

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
}