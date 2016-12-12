package leetcode;

/**
 * Created by zuston on 16-12-12.
 */
public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sum;
    public boolean tag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        if(root==null){
            return false;
        }
        path(root,0);
        return tag;
    }

    public void path(TreeNode root,int temp){
        if(root.left==null&&root.right==null){
            temp += root.val;
            if (this.sum==temp){
                tag = true;
            }
            return ;
        }

        if(root.left!=null){
            path(root.left,temp+root.val);
        }
        if(root.right!=null){
            path(root.right,temp+root.val);
        }
    }
}
