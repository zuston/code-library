package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuston on 16-12-12.
 */
public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelFuntion(root,0,res);
        List<Integer> result = new ArrayList<Integer>();
        for(List<Integer> l:res){
            result.add(l.get(l.size()-1));
        }
        return result;
    }

    public void levelFuntion(TreeNode root,int level,List<List<Integer>> res){
        if(root==null)  return;

        if(level==res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        levelFuntion(root.left,level+1,res);
        levelFuntion(root.right,level+1,res);
    }
}
