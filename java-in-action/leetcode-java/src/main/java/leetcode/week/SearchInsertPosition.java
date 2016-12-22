package leetcode.week;

/**
 * Created by zuston on 16-12-19.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==1)  return nums[0]>=target?0:1;
        if(target<=nums[0])  return 0;
        if(target>nums[nums.length-1])  return nums.length;
        if(target==nums[nums.length-1]) return nums.length-1;
        int i = 0;
        while(i<nums.length-1){
            if(target>nums[i]&&target<nums[i+1])    return i+1;
            if(target==nums[i])     return i;
            if(target>nums[i])      i++;    continue;
        }
        return i;
    }


    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int value = sip.searchInsert(new int[]{1,4,6,8,9,10,23,45},19);
        System.out.println(value);
    }
}
