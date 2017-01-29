120. Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step 
you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n 
is the total number of rows in the triangle.


public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null || triangle.size()==0)
            return 0;
        
        int row = triangle.size();
        int[][] matrix = new int[row][row];

        matrix[0][0] = triangle.get(0).get(0);
        
        for(int i=1; i<row; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0)
                    matrix[i][j] = triangle.get(i).get(j) + matrix[i-1][j];
                else if(j==i)
                    matrix[i][j] = triangle.get(i).get(j) + matrix[i-1][j-1];
                else
                    matrix[i][j] = triangle.get(i).get(j) + Math.min(matrix[i-1][j],
                                                                     matrix[i-1][j-1]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<row; i++)
            if(matrix[row-1][i] < min)
                min = matrix[row-1][i];
        
        return min;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null || triangle.size()==0)
            return 0;
        
        int row = triangle.size();
        
        int[] dp = new int[row];
        for(int i=0; i<row; i++)
            dp[i] = triangle.get(row-1).get(i);
            
        for(int i=row-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        
        return dp[0];
    }
}

