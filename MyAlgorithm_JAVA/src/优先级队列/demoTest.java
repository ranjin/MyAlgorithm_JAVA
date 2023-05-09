package 优先级队列;

import java.util.PriorityQueue;

public class demoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> ());
		PriorityQueue<Integer> pq = new PriorityQueue<>(5, (a, b) -> (a - b));

	    int[] nums = new int[] {3,2,1,5,6,4};
	    
	    for (int e : nums) {
	        // 每个元素都要过一遍二叉堆
	        pq.offer(e);
//	        // 堆中元素多于 k 个时，删除堆顶元素
//	        if (pq.size() > k) {
//	            pq.poll();
//	        }
	    }
	    int size = pq.size();
//	    for (int i = 0; i < size; i++) {
//		    System.out.println(pq.poll());
//		    
//		}
	    
	    pq.poll();
	    for (int i = 0; i < size; i++) {
	    	System.out.println(pq.remove());
	    }
//	    System.out.println(pq.peek());
	}

}
