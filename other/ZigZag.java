/* A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence
 * with fewer than two elements is trivially a zig-zag sequence.
 *
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and
 * negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences
 * are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag
 * sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence,
 * leaving the remaining elements in their original order.
 */

import java.io.*;
import java.util.*;

public class ZigZag {
    public static void main(String[] args) {
        //int[] arr = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}; //7
        //int[] arr = {44}; //1
        //int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };//2
        //int[] arr = { 1, 7, 4, 9, 2, 5 };
        int[] arr = {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}; //8
        /*
        int[] arr = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
            600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
            67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
            477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
            249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }; //36
        */
        solve(arr);
    }
    
    public static void solve(int[] arr) {
        int[] pos_dp = new int[arr.length];
        int[] neg_dp = new int[arr.length];
        int max = 1;

        for(int i=0; i<arr.length; i++) {
            pos_dp[i] = 1;
            neg_dp[i] = 1;

            for(int j=0; j<i; j++) {
                if(arr[i]-arr[j] > 0) {
                    pos_dp[i] = Math.max(pos_dp[i], neg_dp[j]+1);
                    if(pos_dp[i] > max)
                        max = pos_dp[i];
                } else if(arr[i]-arr[j] < 0) {
                    neg_dp[i] = Math.max(neg_dp[i], pos_dp[j]+1);
                    if(neg_dp[i] > max)
                        max = neg_dp[i];
                }
            }
        }

        System.out.println("Result: " + max);
    }
}


/* Dynamic programming
 * pos_dp[i]: maximum length subsequence ending at i such that the difference between the
 *            last two elements is positive
 * neg_dp[i]: same, but difference between the last two is negative
 */
