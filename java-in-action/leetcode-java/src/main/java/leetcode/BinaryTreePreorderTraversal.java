package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zuston on 16-12-5.
 */

/**
 * 跟前序的做法想对称
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> container = new Stack<TreeNode>();
        TreeNode tr = root;
        if (root!=null){
            container.push(root);
        }
        while (!container.isEmpty()){
            TreeNode tmp = container.pop();
            res.add(tmp.val);
            if(tmp.right!=null){
                container.push(tmp.right);
            }
            if(tmp.left!=null){
                container.push(tmp.left);
            }
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {

    }
}
