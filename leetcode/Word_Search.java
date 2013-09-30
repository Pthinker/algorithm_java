Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent 
cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.


// recursive method exceed time limit for large test
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(find(board, visited, i, j, word, 0))
        			return true;
        	}
        }
        return false;
    }

    public boolean find(char[][] board, boolean[][] visited, int i, int j, 
                        String word, int start) {
    	if(board[i][j] != word.charAt(start))
    		return false;
    	
    	if(start == (word.length()-1))
    		return true;

    	visited[i][j] = true;

    	if(i>0 && !visited[i-1][j] && find(board, visited, i-1, j, word, start+1))
    		return true;

    	if(i<(board.length-1) && !visited[i+1][j] && 
                find(board, visited, i+1, j, word, start+1))
    		return true;

    	if(j > 0 && !visited[i][j-1] && 
                find(board, visited, i, j-1, word, start+1))
    		return true;

    	if(j<(board[0].length-1) && !visited[i][j+1] && 
                find(board, visited, i, j+1, word, start+1))
    		return true;

    	visited[i][j] = false;
    	
    	return false;
    }
}

////////////////////////////////////////////////////////////////

//time limit exceeded for large test data
public class Solution {
    public boolean exist(char[][] board, String word) {

        if(word == null || word.length() == 0){
            return true;
        }
    
        char c = word.charAt(0);
    
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(board[i][j] ==c){
                    board[i][j] = 0;
                    if(dfs(board, i, j, word, 1)){
                        return true;
                    }
                    board[i][j] = c;
                }
            }
        }
    
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int k) {

        if(k == word.length()){
            return true;
        }

        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        char c = word.charAt(k);
        int M = board.length;
        int N = board[0].length;
    
        for(int[] d : dir){
            int i = row + d[0];
            int j = col + d[1];
        
            if(0 <= i && i < M && 0 <= j && j < N && board[i][j] == c){
                board[i][j] = 0;
                if(dfs(board, i, j, word, k+1)){
                    return true;
                }
                board[i][j] = c;
            }
        }
        return false;
    }
}


/////////////////////////////////////////////////////////////////////

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0) 
            return true;
        
        int m = board.length;
        int n = board[0].length;
        char[] letters = word.toCharArray();
        boolean[][] tried;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == letters[0]) {
                    tried = new boolean[m][n];
                    Stack<Integer[]> toVisit = new Stack<Integer[]>();
                    Integer[] temp = new Integer[2];
                    temp[0] = i * n + j; 
                    temp[1] = 0;
                    toVisit.push(temp);
                    
                    while(!toVisit.isEmpty()) {
                        Integer[] cur = toVisit.pop();
                        if(!tried[cur[0]/n][cur[0]%n] && 
                                board[cur[0]/n][cur[0]%n]==letters[cur[1]]) {
                            if(cur[1]==word.length()-1) 
                                return true;
                            tried[cur[0]/n][cur[0]%n] = true;
                            
                            for(int ii=-1; ii<=1; ii++) {
                                for(int jj=-1; jj<=1; jj++) {
                                    if((ii==0||jj==0) && cur[0]/n+ii>=0 && 
                                            cur[0]/n+ii<m && cur[0]%n+jj>=0 && 
                                            cur[0]%n+jj<n && 
                                            !tried[cur[0]/n+ii][cur[0]%n+jj]) {
                                        Integer[] temp1 = new Integer[2];
                                        temp1[0] = cur[0]/n*n+ii*n+cur[0]%n+jj;
                                        temp1[1] = cur[1]+1;
                                        toVisit.push(temp1);
                                    }
                                }
                            }
                        }
                    }                 
                }
            }
        }
        return false;
    }
}

