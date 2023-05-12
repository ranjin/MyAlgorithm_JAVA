package 链表;


public class Test_01 {
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	// 比如说给你输入 nums = [0,1,4,0,2]，你的算法没有返回值，但是会把 nums 数组原地修改成 [1,4,2,0,0]。
	//     fast
	//     slow
	//  1,   1,	  4,   0,	2
	// 
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int slow = 0, fast = 0;
		while (fast < n) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		
		while (slow < n) {
			nums[slow] = 0;
			slow++;
		}
	}
	//    fast
	//slow
	// 3,	2,	2,	3
	// 输入：nums = [3,2,2,3], val = 3
	// 输出：2, nums = [2,2]

    public int removeElement(int[] nums, int val) {
    	
    	int slow = 0, fast = 0;
    	while (fast < nums.length) {
			if (nums[slow] == val) {
				fast++;
				nums[slow] = nums[fast];
			}
			fast++;
		}
    	return slow + 1;
    }
	public  ListNode deleteDuplicates(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		//slow     fast
		//
		// 1 -> 1 -> 2
		ListNode slow = head, fast = head.next;
		while (fast != null) {
			if (slow.val == fast.val) {
				fast = fast.next;
			} else {
				slow.next = fast;
				slow = slow.next;
				fast = fast.next;				
			}
		}
		
		return head;
	}
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String aString = "11";
		String bString = "1";
		String ssBuilder = addBinary(aString, bString);
		System.out.println(ssBuilder.toString());
	}

}
