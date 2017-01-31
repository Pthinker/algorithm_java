62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] sum = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    sum[i][j] = 1;
                } else {
                    sum[i][j] = (i > 0 ? sum[i - 1][j] : 0) + 
                                (j > 0 ? sum[i][j - 1] : 0);
                }
            }
        }
        if(m == 0 || n == 0){
            return 0;
        } else {
            return sum[m - 1][n - 1];
        }
    }
}

