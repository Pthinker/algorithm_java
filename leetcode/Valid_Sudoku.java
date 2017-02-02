36. Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with 
the character '.'.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            HashSet hm = new HashSet();
            for(int j = 0; j < board.length; j++){
                if( (board[i][j] != '.') && hm.contains(board[i][j]) )
                    return false;
                hm.add(board[i][j]);
            }
        }

        for(int i = 0; i < board.length; i++){
            HashSet hm = new HashSet();
            for(int j = 0; j < board.length; j++){
                if( (board[j][i] != '.') && hm.contains(board[j][i]) )
                    return false;
                hm.add(board[j][i]);
            }
        }
        
        for(int i = 0; i < board.length; i=i+3){
            for(int j = 0; j < board.length; j = j+3){
                HashSet hs = new HashSet();
                int count = 0;
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        if (board[i+k][j+l]!='.' && hs.contains(board[i+k][j+l]))
                            return false;
                        hs.add(board[i+k][j+l]);
                    }
                }
            }
        }
        return true;
    }
}
