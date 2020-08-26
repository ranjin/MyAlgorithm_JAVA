import java.util.HashMap;
import java.util.Map;

public class 剑指Offer06_重建二叉树 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	//标记中序遍历
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	int[] preorder;	//保留的先序遍历

	/*
	 *	根据前序遍历与中序遍历 
	 */
	public TreeNode buildNode(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return recursive(0, 0, inorder.length-1);
	}
	
	/*
	 * pre_root_idx 先序遍历的索引
	 * in_left_idx 中序遍历的索引 左边界
	 * in_right_idx 中序遍历的索引 右边界
	 */
	public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx){
		TreeNode root = new TreeNode(preorder[pre_root_idx]);
		
		//在中序遍历中获取根的索引
		int idx = map.get(preorder[pre_root_idx]);
		
		//左子树的根节点就是  左子树的第一个 就是+1， 左边边界就是left，右边边界就是中间的idx+1
		root.left = recursive(pre_root_idx+1, in_left_idx, idx-1);
		
		root.right = recursive(pre_root_idx+, in_left_idx, in_right_idx)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}















