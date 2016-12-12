package leetcode;

/**
 * Created by zuston on 16-12-12.
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int tag = 0;
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        isSame(root.left,root.right);
        return tag==0?true:false;
    }


    public void isSame(TreeNode p,TreeNode q){
        if((p!=null&&q==null)||(q!=null&&p==null)){
            tag = 1;
            return;
        }
        if(p==null&&q==null){
            return;
        }

        if(p.val==q.val){
            isSame(p.left,q.right);
            isSame(p.right,q.left);
        }else{
            tag=1;
            return;
        }
    }
}
