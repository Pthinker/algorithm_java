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


//run dfs on all four side(the first outer layer of the matrix) mark +
//scan whole matrix, if see O, mark X else if +, mark O
//dfs
public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board==null || board.length==0) 
        	return;

        int row = board.length-1;
        int col = board[0].length-1;

        for(int i=0; i<=row; i++) {
        	//first column
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            //last column
            if(board[i][col] == 'O')
                dfs(board, i, col);
        }

        for(int i=1; i<col; i++) {
        	//first row
            if(board[0][i]=='O')
                dfs(board, 0, i);
            //last row
            if(board[row][i]=='O')
                dfs(board, row, i);
        }

        for(int i=0; i<=row; i++) {
            for(int j=0; j<=col; j++) {
                if(board[i][j]=='O') 
                	board[i][j]='X';
                else if(board[i][j]=='+') 
                	board[i][j] ='O';
            }
        }
    }

    public void dfs(char[][] board, int x, int y){
        board[x][y] = '+';
        if(x-1>=0 && board[x-1][y]=='O')
            dfs(board, x-1, y);
        if(y-1>=0 && board[x][y-1]=='O')
            dfs(board, x, y-1);
        if(x+1<board.length && board[x+1][y]=='O')
            dfs(board, x+1, y);
        if(y+1 <board[0].length && board[x][y+1]=='O')
            dfs(board, x, y+1);
    }
}

/////////////////////////////////////////////////////////////////////////////////

//bfs
public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board==null || board.length==0) 
        	return;

        int row = board.length-1;
        int col = board[0].length-1;

        for(int i=0; i<=row; i++) {
            bfs(board, i, 0);
            bfs(board, i, col);
        }
        for(int i=1; i<col; i++) {
            bfs(board,0,i);
            bfs(board,row,i);
        }

        for(int i=0; i<=row; i++) {
            for(int j=0; j<=col; j++) {
                if(board[i][j]=='O') 
                	board[i][j]='X';
                else if(board[i][j]=='+') 
                	board[i][j] ='O';
            }
        }
    }

    public void bfs(char[][]board, int x, int y) {
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        if(board[x][y]=='O')
            queue.add(new Integer[]{x,y});

        while(queue.size()>0) {
            Integer[] curr = queue.poll();
            x = curr[0]; 
            y = curr[1];
            board[x][y] = '+';
            if(x-1>=0 && board[x-1][y] == 'O')
                queue.add(new Integer[]{x-1,y});
            if(y-1 >=0 && board[x][y-1] == 'O')
                queue.add(new Integer[]{x,y-1});
            if(x+1<board.length && board[x+1][y] == 'O')
                queue.add(new Integer[]{x+1,y});
            if(y+1 <board[0].length && board[x][y+1] == 'O')
                queue.add(new Integer[]{x,y+1});
        }
    }
}
