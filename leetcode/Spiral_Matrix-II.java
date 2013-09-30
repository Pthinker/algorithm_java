Given an integer n, generate a square matrix filled with elements 
from 1 to n^2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        
        int c = 1;
        for(int layer=0; layer<(n+1)/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            
            int i = 0;
            //top row
            for(i=first; i<=last; i++)
                matrix[first][i] = c++;
            if(c>n*n)
                break;
            
            //right column
            for(i=first+1; i<=last-1; i++)
                matrix[i][last] = c++;
            
            //bottom row
            for(i=last; i>=first; i--)
                matrix[last][i] = c++;
            
            //left column
            for(i=last-1; i>=first+1; i--)
                matrix[i][first] = c++;
        }
        
        return matrix;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {  
    public int[][] generateMatrix(int n) {           
        int[][] res = new int[n][n];  
        
        if(n<1)
        	return res;
          
        int top=0, bottom=n-1, left=0, right=n-1;  
          
        int loop = (n+1)/2;
          
        for(int i=0, seq=1; i<loop; i++) {             
            for(int j=left; j<=right; j++) {
                res[top][j] = seq++;
            }
            top++;
              
            if(top>bottom) 
            	return res;

            for(int j=top; j<=bottom; j++) {
                res[j][right] = seq++;  
            }  
            right--;  
              
            if(left>right) 
                return res;

            for(int j=right; j>=left; j--) {  
                res[bottom][j] = seq++;  
            }  
            bottom--;  
              
            if(top>bottom) 
                return res;  
            for(int j=bottom; j>=top; j--) {  
                res[j][left] = seq++;  
            }  
            left++;  
        }  
          
        return res;  
    }  
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][];
        for(int i = 0; i < n; i++) { 
        	matrix[i] = new int[n];
        }
		fillMatrix(0, 0, matrix);
		return matrix;
    }

    public void fillMatrix(int level, int baseValue, int[][] matrix) {
    	if(baseValue == matrix.length * matrix.length) {
    		return;
    	}

    	for(int j = level; j < matrix.length - level; j++) {
    		matrix[level][j] = ++baseValue;
    	}

    	for(int i = level + 1; i < matrix.length - level; i++) {
    		matrix[i][matrix.length - level - 1] = ++baseValue;
    	}

		for(int j = matrix.length - level - 2; j >= level; j--) {
			matrix[matrix.length - level - 1][j] = ++baseValue;
		}

		for(int i = matrix.length - level - 2; i > level; i--) {
			matrix[i][level] = ++baseValue;
		}

		fillMatrix(level + 1, baseValue, matrix);
	}
}
