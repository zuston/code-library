package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zuston on 16-12-5.
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> container = new Stack<TreeNode>();
        TreeNode nroot = root;
        while (nroot!=null||!container.isEmpty()){
            if(nroot!=null){
                container.push(nroot);
                nroot = nroot.left;
            }else{
                TreeNode tmp = container.pop();
                res.add(tmp.val);
                nroot = tmp.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
