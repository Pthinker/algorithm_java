/* You are given an array of integers (both positive and negative). Find the contiguous 
 * sequence with the largest sum. Return the sum.
 */

import java.io.*;
import java.util.*;

public class  MaxSumSubarray {
    public static void main(String[] args) {
        //int[] arr = {2, 3, -8, -1, 2, 4, -2, 3};
        int[] arr = {-3, -4, -5, -1, -6};
        solve(arr);
    }
    
    public static void solve(int[] arr) {
        int max = arr[0];
        int cur = 0;
        for(int i=0; i<arr.length; i++) {
            cur += arr[i];
            if(cur>max)
                max = cur;
            if(cur < 0)
                cur = 0;
        }

        System.out.println("Largest contiguous sum:" + max);
    }
}
