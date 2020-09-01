package 剑指Offer;

public class 面试题42_翻转单词顺序 {

    public String reverseWords(String s) {
		//删除首位空格
    	s = s.trim();
    	StringBuilder res = new StringBuilder();
    	int j = s.length() - 1;
    	int i = j;
    	
    	while (i >= 0) {
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			res.append(s.substring(i - 1, j + 1) + " ");
			
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			j = i;
		}
    	return s.toString().trim();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
