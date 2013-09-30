/* If we have a number of coins with value 1, 3 and 5. What is the minimum 
 * number of coins to get 11?
 */

import java.io.*;
import java.util.*;

public class MinCoinNum {
    public static void main(String[] args) {
        int[] values = {1, 3, 5};
        solve(values, 11);
    }

    public static void solve(int[] values, int sum) {
        int[] d = new int[sum+1];
        int[] path = new int[sum+1];
        d[0] = 0;
        path[0] = -1;
        
        for(int i=1; i<=sum; i++) {
            int min = Integer.MAX_VALUE;
            int p = -1;
            boolean flag = false;
            for(int j=0; j<values.length; j++) {
                if(values[j]<=i) {
                    if(d[i-values[j]]==0 && i-values[j]>0)
                        continue;
                    if((d[i-values[j]]+1) < min) {
                        min = d[i-values[j]]+1;
                        p = i-values[j];
                        flag = true;
                    }
                }
            }

            if(!flag) {
                d[i] = 0;
            }
            else {
                d[i] = min;
                path[i] = p;
            }
        }
        
        if(d[sum]>0) {
            System.out.println(d[sum]);
            int a = sum;
            while(path[a] >= 0) {
                System.out.print(a - path[a] + " ");
                a = path[a];
            }
            System.out.println();
        } else {
            System.out.println("Do not have solution!");
        }
    }
}

