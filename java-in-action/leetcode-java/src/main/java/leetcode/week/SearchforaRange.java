package leetcode.week;

/**
 * Created by zuston on 16-12-19.
 */
public class SearchforaRange {

    public static int[] searchRange(int[] nums, int target) {

        int value = search(nums,0,nums.length-1,target);
        if(value==-1)   return new int[]{-1, -1};
        int left = value;
        int right = value;
        while (--left>=0){
            if (nums[left]==target) continue;
            else    break;
        }

        while (++right<=nums.length-1){
            if(nums[right]==target)   continue;
            else    break;
        }
        System.out.println("left:"+(left+1)+"  right:"+(right-1));
        return new int[]{left+1,right-1};
    }


    public static int search(int[] nums,int left,int right,int target){
        int mid = (left+right)/2;
        System.out.println("mid="+mid);
        if(left>right)  return -1;
        if(nums[mid]>target)    right = mid-1;
        if(nums[mid]<target)    left = mid+1;
        if(nums[mid]==target)   return mid;
        System.out.println("left="+left+" right="+right);
        return search(nums,left,right,target);
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        SearchforaRange.searchRange(nums,3);
        SearchforaRange.searchRange(nums,2);
    }
}
