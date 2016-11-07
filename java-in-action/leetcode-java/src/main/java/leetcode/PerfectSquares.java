package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuston on 16/11/6.
 */
public class PerfectSquares {

    public List<Integer> list = new ArrayList<Integer>();
    public int numSquares(int n) {
        double count = 1;
        while (true) {
            if(Math.pow(count,2)<=n&&Math.pow(count+1,2)>=n){
                break;
            }
            count++;
        }
        int number = (int)count+1;
        int arr[] = new int[number];
        for (int i=0;i<number;i++){
            arr[i] = (int) Math.pow((double)(i+1),2.0);
        }
        search(arr,n,0);
        Integer min = list.get(0);
        for (Integer integer : list) {
            if (integer>0){
                min = min>integer?integer:min;
            }
        }
        return min;
    }

    public int search(int [] arr,int target,int step){
        if(target==0){
            list.add(step);
            return step;
        }
        if(target<0){
            list.add(-1);
            return -1;
        }
        for(int i=0;i<arr.length;i++){
            search(arr,target-arr[i],step+1);
//            search(arr,target,step);
        }
        return -1;
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(12));
    }
}
