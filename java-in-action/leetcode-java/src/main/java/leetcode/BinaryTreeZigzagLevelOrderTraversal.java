package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuston on 16-12-12.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelFunc(root,0,res,true);
        return res;
    }

    public void levelFunc(TreeNode root,int level,List<List<Integer>> res,boolean tag){
        if(root==null)  return;

        if(level==res.size())   res.add(new ArrayList<Integer>());

        if(tag){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0,root.val);
        }
        levelFunc(root.left,level+1,res,!tag);
        levelFunc(root.right,level+1,res,!tag);
    }
}
