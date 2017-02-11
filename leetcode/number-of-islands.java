200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3


// BFS
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[]{i, j});
                    while(queue.size()>0) {
                        int[] p = queue.poll();
                        grid[p[0]][p[1]] = '0';
                        for(int[] dir : dirs) {
                            int x = p[0] + dir[0];
                            int y = p[1] + dir[1];
                            if(x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0') {
                                continue;
                            } else {
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}


public class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfsFill(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();  
        int code = x*m+y;  
        queue.offer(code);  
        while(!queue.isEmpty())  
        {  
            code = queue.poll();  
            int i = code/m;  
            int j = code%m;  
            if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
            {  
                queue.offer((i-1)*m+j);  
                grid[i-1][j]='0';  
            }  
            if(i<n-1 && grid[i+1][j]=='1')  //down
            {  
                queue.offer((i+1)*m+j);  
                grid[i+1][j]='0';  
            }  
            if(j>0 && grid[i][j-1]=='1')  //left
            {  
                queue.offer(i*m+j-1);  
                grid[i][j-1]='0';  
            }  
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {  
                queue.offer(i*m+j+1);  
                grid[i][j+1]='0';  
            }
        }
    }
}

////////////////////////////////////////////////////////////

//DFS
public class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void dfsFill(char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }
}


