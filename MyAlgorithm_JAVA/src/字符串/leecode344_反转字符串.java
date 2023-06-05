package 字符串;

public class leecode344_反转字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void reverseString(char[] s) {
    	int n = s.length;
    	int i = 0, j = n;
    	while (i <= j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
    }
}
