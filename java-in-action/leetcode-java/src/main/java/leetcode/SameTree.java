package leetcode;

/**
 * Created by zuston on 16-12-12.
 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int tag = 0;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        issame(p,q);
        return tag==0?true:false;
    }

    public void issame(TreeNode p,TreeNode q){
        if((p!=null&&q==null)||(q!=null&&p==null)){
            tag = 1;
            return;
        }
        if(p==null&&q==null){
            return;
        }

        if(p.val==q.val){
            isSameTree(p.left,q.left);
            isSameTree(p.right,q.right);
        }else{
            tag=1;
            return;
        }
    }
}
