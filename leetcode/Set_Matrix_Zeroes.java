Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow=false, firstColumn=false;
        for(int i=0;i<matrix.length;i++) {
            if(matrix[i][0]==0) { 
                firstColumn = true;
                break;
            }
        }
        
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                firstRow = true;
                break;
            }
        }
    
        for(int i=1; i<matrix.length;i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++) {
            for(int j=1;j<matrix[0].length;j++) {
                if(matrix[i][0]==0||matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        
        if(firstRow){
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i]=0;
        }
        
        if(firstColumn){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;
        }
    }
}
