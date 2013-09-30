/*
 *
 */

import java.io.*;
import java.util.*;

public class knapsack {
    public static void main(String[] args) {
        /*
        int[] weight = {4, 3, 5, 2, 5};
        int[] value = {9, 6, 1, 4, 1};
        int capacity = 10;
        */

        /*
        int[] weight = {4, 3, 4, 2};
        int[] value = {20, 6, 20, 4};
        int capacity = 9;
        */

        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capacity = 10;

        solve(weight, value, capacity);
    }
    
    public static void solve(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=capacity; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else {
                    if(weight[i-1]<=j) {
                        dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j-weight[i-1]]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        System.out.println("Result: " + dp[n][capacity]);
    }
}
