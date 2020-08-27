package 剑指Offer;

/*
 * 1. 在树A中找到和B的根节点一样的节点R
 * 2. 在判断A中以R为根节点的子树是不是包含和树B一样的结构
 */
public class 树的子结构 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		boolean result = false;
		if (A != null && B != null) {
			if (A.val == B.val) {
				result = DoesTree1HavaTree2(A, B);
			}
			if (!result) {
				result = isSubStructure(A.left, B);
			}
			if (!result) {
				result = isSubStructure(A.right, B);
			}
		}
		return result;
	}
	
	public boolean DoesTree1HavaTree2(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}
		if (A == null) {
			return false;
		}
		if (A.val != B.val) {
			return false;
		}
		return DoesTree1HavaTree2(A.left, B.left) && DoesTree1HavaTree2(A.right, B.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
