package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuston on 16-12-12.
 */
public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sum;
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        path(root,0,new ArrayList<Integer>());
        return res;
    }

    public void path(TreeNode root,int temp,ArrayList<Integer> tempArr){
        if(root.left==null&&root.right==null){
            temp += root.val;
            tempArr.add(root.val);
            if (this.sum==temp){
                res.add(tempArr);
            }
            tempArr.remove(tempArr.size()-1);
            return ;
        }

        if(root.left!=null){
            path(root.left,temp+root.val,tempArr);
        }
        if(root.right!=null){
            path(root.right,temp+root.val,tempArr);
        }
        tempArr.remove(tempArr.size()-1);
    }
}
