package 剑指Offer;

public class 面试题42_2_左旋转字符串 {

	public String reverseLeftWords(String s, int n) {
		return s.substring(n, s.length()) + s.substring(0, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
