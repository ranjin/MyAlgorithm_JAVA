package 数组;

import java.util.Iterator;
import java.util.PriorityQueue;

public class testDemo {

//   slow      fast    
//	 [0,	0,	1,	1,	2,	2,	3,	3,	4]

	public int removeDuplicates(int[] nums) {
		
		
		int slow = 0, fast = 1;
		
		if (nums[slow] == nums[fast]) {
			fast++;
		}
		
		if (nums[slow] != nums[fast]) {
			slow++;
			nums[slow] = nums[fast];
			fast++;
		}
		fast++;
	}
	
	put(int key, int val) {
		if ([map containsKey:key]) {
			deleteKey(key);	// map和cache中
			
			adddRecently()
			return;
		}
		
		if (cap == cache.size()) {
			removeLastRecently();
		}
		
		addRecent
	}
}
