package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的组合 {

    public List<String> letterCombinations(String digits){
    	if (digits == null) {
			return null;
		}
    	List<String> list = new ArrayList<String>();
    	char[] chars = digits.toCharArray();
    	if (chars.length == 0) {
			return list;
		}
    }

    /*
     * 
     */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
