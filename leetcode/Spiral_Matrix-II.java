59. Spiral Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

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
//计算环数时用n / 2来计算，若n为奇数时，此时最中间的那个点没有被算在环数里，所以最后需要单独赋值
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int val=1;
        int p=n;
        for(int i=0; i<n/2; ++i, p-=2) {
            for(int col=i; col<i+p; ++col)
                res[i][col] = val++;
            for(int row=i+1; row<i+p; ++row)
                res[row][i+p-1] = val++;
            for(int col=i+p-2; col>=i; --col)
                res[i+p-1][col] = val++;
            for(int row=i+p-2; row>i; --row)    
                res[row][i] = val++;
        }
        if (n%2!=0) {
            res[n/2][n/2] = val;
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
