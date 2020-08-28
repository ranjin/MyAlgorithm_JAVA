package 剑指Offer;

public class 面试题24_二叉搜索树的后序遍历序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 思路：
	 * 1. 通过后序遍历找到根节点
	 * 2. 二叉搜索树的校验
	 */
	public boolean verifyPostorder(int[] postorder) {
		return verifySeq(postorder, 0, postorder.length-1);
	}

	public static boolean verifySeq(int[] postorder, int start, int end) {
        if(start >= end) return true;

		int p = start;
		while (postorder[p] < postorder[end]) {
			p++;
		}
		int m = p;	//递归标记
		
		while (postorder[p] > postorder[end]) {
			p++;
		}
		
		return p == end && verifySeq(postorder, start, m-1) && verifySeq(postorder, m, end-1);
	}
}
