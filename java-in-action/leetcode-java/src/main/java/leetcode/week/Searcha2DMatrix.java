package leetcode.week;

/**
 * Created by zuston on 16-12-19.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int size = matrix.length;
        int oneLength = matrix[0].length;
        int count = size-1;
        while(count>=0){
            System.out.println("count="+count+" size="+(oneLength-1));
            if(matrix[size][0]>target&&matrix[size][oneLength-1]<target){
                break;
            }
            if(matrix[size][0]==target||matrix[size][oneLength-1]==target){
                return true;
            }
            count--;
        }
        if(count<0)     return false;
        return ser(matrix[count],0,matrix[count].length-1,target);

    }

    public Boolean ser(int[] nums,int left,int right,int target){
        int mid = (left+right)/2;
        System.out.println("mid="+mid);
        if(left>right)  return false;
        if(nums[mid]>target)    right = mid-1;
        if(nums[mid]<target)    left = mid+1;
        if(nums[mid]==target)   return true;
        System.out.println("left="+left+" right="+right);
        return ser(nums,left,right,target);
    }

    public static void main(String[] args) {

    }
}
