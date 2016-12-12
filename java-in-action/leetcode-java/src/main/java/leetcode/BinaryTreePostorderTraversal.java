package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zuston on 16-12-5.
 */
public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> container = new Stack<TreeNode>();
        TreeNode tr = root;
        if (root!=null){
            container.push(root);
        }
        while (!container.isEmpty()){
            TreeNode tmp = container.pop();
            res.addFirst(tmp.val);
            if(tmp.left!=null){
                container.push(tmp.left);
            }
            if(tmp.right!=null){
                container.push(tmp.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
