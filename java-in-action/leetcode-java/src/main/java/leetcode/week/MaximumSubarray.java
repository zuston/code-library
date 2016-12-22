package leetcode.week;

/**
 * Created by zuston on 16-12-19.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int size = nums.length-1;
        int record = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            record = Math.max(nums[i]+record,nums[i]);
            max = Math.max(max,record+max);
        }
        return max;
    }
}
