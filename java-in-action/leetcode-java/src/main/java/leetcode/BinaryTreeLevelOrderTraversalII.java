package leetcode;

import java.util.*;

/**
 * Created by zuston on 16-12-5.
 */
public class BinaryTreeLevelOrderTraversalII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<List> queue = new LinkedList<List>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
            return Arrays.asList();
        }
        queue.add(Arrays.asList(root,0));
        while (!queue.isEmpty()){
            List tmp = queue.remove();
            TreeNode tr = (TreeNode) tmp.get(0);
            Integer i = (Integer) tmp.get(1);
            System.out.println(res.size());

            if(res.size()<i+1){
                res.add(new ArrayList<Integer>());
            }
            res.get(i).add(tr.val);
            if(tr.left!=null){
                queue.add(Arrays.asList(tr.left,i+1));
            }

            if(tr.right!=null){
                queue.add(Arrays.asList(tr.right,i+1));

            }
        }

        Collections.reverse(res);
        return res;
    }
}
