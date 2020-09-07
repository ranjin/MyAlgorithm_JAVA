package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeeCode49_字母异位词分组 {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		
        HashMap<String, List> ans = new HashMap<String, List>();
		for (String string : strs) {
			char[] ca = string.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList());
			}
			ans.get(key).add(string);
		}
		return new ArrayList<List<String>>();
	}
}




