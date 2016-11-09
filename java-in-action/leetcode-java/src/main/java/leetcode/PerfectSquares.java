package leetcode;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zuston on 16/11/6.
 */


/**
 * 递归超时
 * 可以用背包问题的解法做
 * --------完全背包问题----------
 *
 */
public class PerfectSquares {

    public List<Integer> list = new ArrayList<Integer>();
    public int numSquares(int n) {
        /**
         * dp算法
         */
        System.out.println(dynamtic2(n));
        /**
         * 递归算法
         */
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


    public int dynamtic(int n){
        CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<Integer>();
        double count = 1;
        while (true) {
            if(Math.pow(count,2)<=n&&Math.pow(count+1,2)>=n){
                break;
            }
            count++;
        }
        int number = (int)count+1;
        for (int i=0;i<number;i++){
            arr.add((int) Math.pow((double)(i+1),2.0));
        }
        System.out.println(arr);
//        将完全背包转换为0-1背包问题
        for (int one:arr){
            int conn = n/one;
            for(int i=0;i<conn-1;i++){
                arr.add(one);
            }
        }
        System.out.println(arr);
        int pack[][] = new int[arr.size()][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(pack[i],Integer.MAX_VALUE);
            pack[0][i] = 0;
        }

        for(int i=1;i<arr.size();i++){
            int one = arr.get(i);
            for(int j=one;j<=n;j++){
                pack[i][j] = Math.min(pack[i-1][j-one]+1,pack[i-1][j]);
            }
        }
        System.out.println(Arrays.toString(pack[arr.size()-1]));
        return 0;
    }


    public int dynamtic2(int n){
        int [] pack = new int[n+1];
        Arrays.fill(pack,Integer.MAX_VALUE);
        for(int i=0;i*i<=n;i++){
            pack[i*i] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;i+j*j<=n;j++){
                pack[i+j*j] = Math.min(pack[i]+1,pack[i+j*j]);
            }
        }
        return pack[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(28));
    }
}
