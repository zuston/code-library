package leetcode.week;

/**
 * Created by zuston on 16-12-19.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int t = min;
            min = Math.min(nums[i]*max,Math.min(nums[i]*min,nums[i]));
            max = Math.max(Math.max(nums[i]*t,nums[i]*max),nums[i]);
            System.out.println("max="+max);
            res = Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args) {
        int value = MaximumProductSubarray.maxProduct(new int[]{0,2});
        System.out.println(value);
    }
}
