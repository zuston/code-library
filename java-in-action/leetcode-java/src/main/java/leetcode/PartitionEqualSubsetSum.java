package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by zuston on 16/11/4.
 */


/**
 * Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.

 找出一组数据能够对半分
 用递归是很简单的，两种情况，属于还是不属于，oj显示超时了，必然状况
 对于属于与不属于的问题，可以演变为0-1背包问题，因为是放呢还是不放，用呢还是不用这两个问题，于是可以用动态规划解决
 c[i,w]=c[i-1,w-v]+v放的时候
 c[i,w]=max(c[i-1,w-v]+v,c[i-1,w])

 ------0-1背包问题------
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for(int i=0;i<nums.length;i++){
//            sum += nums[i];
//        }
//        if(sum%2!=0){
//            return false;
//        }
//        return search(nums,sum/2,0);
        return dynamtic(nums);
    }

    public boolean search(int []nums,int sum,int k){
        if(sum==0){
            return true;
        }
        if(k==nums.length&&sum!=0){
            return false;
        }
        boolean f1 = search(nums,sum-nums[k],k+1);
        boolean f2 = search(nums,sum,k+1);
        return f1||f2;
    }


    /**
     * 0-1背包问题的变种
     * 求最后的满载的东西正好重量正好是背包所能容纳的重量
     * @param nums
     * @return
     */
    public boolean dynamtic(int nums[]){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        //声明一个数组
        int dp[][] = new int[nums.length][sum/2+1];
        //初始化，是在i=0时候，就是只要0物品是，背包容量为nums[0]到sum/2时候的背包内放置物品的重量
        for(int i=nums[0];i<=sum/2;i++){
            dp[0][i] = nums[0];
        }

        //递推公式
        for(int i=1;i<nums.length;i++){
            for(int j=nums[i];j<=sum/2;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
            }
        }
        if(dp[nums.length-1][sum/2]==sum/2){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        PartitionEqualSubsetSum pe = new PartitionEqualSubsetSum();
        int a [] = {1,6,11,19};
        System.out.println(pe.canPartition(a));
    }

}
