/* Given a unsorted array of positive integers, find the maximum sum 
 * obtained by adding non-contiguous integers.
 */

import java.io.*;
import java.util.*;

public class MaxNonContiguousSum {
    public static void main(String[] args) {
        int[] arr = {8, 10, 2, 3, 4, 5};

        System.out.println(max_sum(arr));
    }

    public static int max_sum(int[] arr) {
        if(arr.length==1)
            return arr[0];
        else if(arr.length==2)
            return Math.max(arr[0], arr[1]);
        else {
            int[] cache = new int[arr.length];
            cache[0] = arr[0];
            cache[1] = arr[1]>arr[0]?arr[1]:arr[0];
            for(int i=2; i<cache.length; i++) {
                cache[i] = Math.max(cache[i-1], arr[i]+cache[i-2]);
            }
            return cache[cache.length-1];
        }
    }
}
