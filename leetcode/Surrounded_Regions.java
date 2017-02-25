Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region . 
For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be: 
X X X X
X X X X
X X X X
X O X X


//run dfs or bfs on all four side(the first outer layer of the matrix) mark +
//scan whole matrix, if see O, mark X else if +, mark O

//dfs
public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1); 
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j); 
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);
    }
}

////////////////////////////////////////////////////////////////////////

//bfs
public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        
        int rowN = board.length;
        int colN = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
       
        //get all 'O's on the edge first
        for (int r = 0; r< rowN; r++) {
            if (board[r][0] == 'O') {
                queue.add(new int[]{r, 0});
            }
            if (board[r][colN-1] == 'O') {
                queue.add(new int[]{r, colN-1});
            }
        }
        
        for (int c = 0; c< colN; c++) {
            if (board[0][c] == 'O') {
                queue.add(new int[]{0, c});
            }
            if (board[rowN-1][c] == 'O') {
                board[rowN-1][c] = '+';
                queue.add(new int[]{rowN-1, c});
            }
        }

        //BFS for the 'O's, and mark it as '+'
        while (!queue.isEmpty()){
            int[] p = queue.poll();
            board[p[0]][p[1]] = '+';
            int row = p[0];
            int col = p[1];
            if (row - 1 >= 0 && board[row-1][col] == 'O') queue.add(new int[]{row-1, col});
            if (row + 1 < rowN && board[row+1][col] == 'O') queue.add(new int[]{row+1, col});
            if (col - 1 >= 0 && board[row][col - 1] == 'O') queue.add(new int[]{row, col-1});
            if (col + 1 < colN && board[row][col + 1] == 'O') queue.add(new int[]{row, col+1});
        }
        
        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i<rowN; i++){
            for (int j=0; j<colN; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }
}
