490. The Maze

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won''t stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball''s start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won''t exceed 100.


//BFS
public class Solution {
    class Point {
        int x,y;
        public Point(int _x, int _y) {x=_x;y=_y;}
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m=maze.length, n=maze[0].length;
        if (start[0]==destination[0] && start[1]==destination[1]) return true;
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited=new boolean[m][n];
        LinkedList<Point> list=new LinkedList<>();
        visited[start[0]][start[1]]=true;
        list.offer(new Point(start[0], start[1]));
        while (!list.isEmpty()) {
            Point p=list.poll();
            int x=p.x, y=p.y;
            for (int i=0;i<4;i++) {
                int xx=x, yy=y;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                }
                xx-=dir[i][0];
                yy-=dir[i][1];
                if (visited[xx][yy]) continue;
                visited[xx][yy]=true;
                if (xx==destination[0] && yy==destination[1]) return true;
                list.offer(new Point(xx, yy));
            }
        }
        return false;
        
    }
}

//////////////////////////////

// DFS
public class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length ==0){
            return false;
        }
        if(maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] ==1){
            return false;
        }
        
        int row = maze.length;
        int col = maze[0].length;
        Boolean[][] memo = new Boolean[row][col];
        return helper(maze, memo, start[0], start[1], destination[0], destination[1], row, col);
    }
    
    
    public boolean helper(int[][] maze, Boolean[][] memo, int si, int sj, int di, int dj, int row, int col){
        if(si == di && sj == dj){
            return true;
        }
        
        if(memo[si][sj] != null){
            return memo[si][sj];
        }
        
        maze[si][sj] = -1; // mark as visited.
        
        boolean res = false;
        for(int[] dir : dirs){
            // until we reach the edge or wall;
            
            int x = si;
            int y = sj;
            
            while(x+dir[0] >=0 && x+dir[0] < row && y+dir[1] >=0 && y+dir[1] < col && maze[x+dir[0]][y+dir[1]] != 1){
                x+=dir[0];
                y+=dir[1];
            }
            
            //so that x,y is the next point in this direction;
            
            if(maze[x][y] != -1){
                res |=helper(maze, memo, x, y, di, dj, row, col);
            }
        }
        
        maze[si][sj] = 0;
        memo[si][sj] = res;
        
        return res;
    }
}
