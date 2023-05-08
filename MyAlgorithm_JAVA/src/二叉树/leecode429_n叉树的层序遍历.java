package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leecode429_n叉树的层序遍历 {

	public class Node {
		int val;
		List<Node> children;
	}
	
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> res = new LinkedList<>();
    	if (root == null) {
    		return res;
    	}
    	Queue<Node> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				Node cur = queue.poll();
				level.add(cur.val);
				for (Node children : cur.children) {
					queue.offer(children);
				}
			}
			// 当前层遍历完毕
			res.add(level);
		}
    	return res;
    }
}
