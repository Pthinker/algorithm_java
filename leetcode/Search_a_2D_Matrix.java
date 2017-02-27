74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This 
matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the 
previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left=0;
        int right=n*m-1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            int x = mid/n;
            int y = mid%n;
            if(matrix[x][y] == target) {
                return true;
            } else if(matrix[x][y] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}

//////////////////////////

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;

        int start = 0, end = matrix.length*matrix[0].length-1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / matrix[0].length;
            int midY = mid % matrix[0].length;

            if(matrix[midX][midY] == target) 
            	return true;

            if(matrix[midX][midY] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
