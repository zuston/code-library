package leetcode;

/**
 * Created by zuston on 16-12-12.
 */
public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode tmpRoot = root;

        invert(tmpRoot);
        return root;
    }

    public void invert(TreeNode tmpRoot){
        if(tmpRoot==null)   return;
        TreeNode t = tmpRoot.left;
        tmpRoot.left = tmpRoot.right;
        tmpRoot.right = t;
        invert(tmpRoot.left);
        invert(tmpRoot.right);
    }
}
