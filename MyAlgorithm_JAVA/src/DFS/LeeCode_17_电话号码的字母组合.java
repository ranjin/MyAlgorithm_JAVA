package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * 比如：2对应的为"abc"，3对应的是"def"
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 输入：digits = ""
 * 输出：[]
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 0 <= digits.length <= 4
 */
public class LeeCode_17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
    	if (digits == null) {
			return null;
		}
    	List<String> list = new ArrayList<>();
    	char[] chars = digits.toCharArray();
    	if (chars.length == 0) {
			return list;
		}
    	dpf(0);
    	return list;
    }

    /**
     * 正在搜索第idx层
     */
	private void dpf(int idx) {
		// TODO Auto-generated method stub
		
	}
}



















