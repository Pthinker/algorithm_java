/* For an array, find the length of longest increasing subsequence
 *
 */

import java.io.*;
import java.util.*;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        solve(arr);
    }
    
    public static void solve(int[] arr) {
        int[] l = new int[arr.length];
        int[] prev = new int[arr.length];
        int max = 1;
        int maxEnd = 0;

        for(int i=0; i<arr.length; i++) {
            l[i] = 1;
            prev[i] = -1;

            for(int j=0; j<i; j++) {
                if(arr[i]>=arr[j] && l[j]+1>l[i]) {
                    l[i] = l[j] + 1;
                    prev[i] = j;
                }
            }

            if(l[i] > max) {
                max = l[i];
                maxEnd= i;
            }
        }

        System.out.println("Max length: " + max);
        
        System.out.println("The sequence is:");
        int i = maxEnd;
        while(i>=0) { 
            System.out.println(arr[i]);
            i = prev[i];
        }
    }
}

