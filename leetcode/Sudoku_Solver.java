Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


import java.util.Set;
import java.util.HashSet;

public class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<int[]> empty = new ArrayList<int[]>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]=='.') {
                    int[] tmp = {i, j};
                    empty.add(tmp);
                }
            }
        }
        dfs(board, empty, 0);
    }
    
    public boolean dfs(char[][] board, ArrayList<int[]> empty, int index) {
        int[] cur = empty.get(index);
        int row = cur[0];
        int col = cur[1];
        for(int i=1; i<=9; i++) {
            if(isValid(board, row, col, i)) {
                board[row][col] = (char)('0'+i);
                if(index==empty.size()-1) {
                    return true;
                } else {
                    if(dfs(board, empty, i+1)) {
                        return true;
                    } else {
                        board[col][row] = '.';
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, int value) {
        for(int i=0; i<9; i++) {
            if(Character.getNumericValue(board[row][i])==value) {
                return false;    
            }
            
            if(Character.getNumericValue(board[i][col])==value) { 
                return false;   
            }
            
            int row_s = 3*(int)(row/3) + (int)(i/3);  
            int col_s = 3*(int)(col/3) + i%3;  
            if(Character.getNumericValue(board[row_s][col_s])==value) {
                return false;   
            }
        }
        
        return true;
    }
}
