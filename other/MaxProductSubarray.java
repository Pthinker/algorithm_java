/* Given an array that contains both positive and negative integers, find 
 * the product of the maximum product subarray. Expected Time complexity is 
 * O(n) and only O(1) extra space can be used.
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 */

import java.io.*;
import java.util.*;

public class MaxProductSubarray {
    public static void main(String[] args) {
        //int[] arr = {6, -3, -10, 0, 2};
        //int[] arr = {-1, -3, -10, 0, 60};
        int[] arr = {-2, -3, 0, -2, -40};

        solve(arr);
    }
    
    public static void solve(int[] arr) {
        int prod = 1;
        int max = Integer.MIN_VALUE;
        int last_neg_prod = 0;

        for(int i=0; i<arr.length; i++) {
            prod *= arr[i];

            if(prod < 0) {
                if(last_neg_prod < 0) {
                    prod = prod * last_neg_prod;
                    last_neg_prod = 0;
                } else {
                    last_neg_prod = prod;
                    prod = 1;
                }
            } else if(prod == 0)  {
                last_neg_prod = 0;
                prod = 1;
            }

            if(max < prod)
                max = prod;
        } 

        System.out.println("Max: " + max);
    }
}
