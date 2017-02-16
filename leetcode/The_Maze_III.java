499. The Maze III

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won''t stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.


//https://discuss.leetcode.com/topic/77074/clear-java-accepted-dfs-solution-with-explanation
public class Solution {
    int min; //min distance to hole
    String minS; //min distance's path string
    int[] hole;
    int[][] maze; 
    int[][] map; //shortest distant traveling from ball to this point
    int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1}}; //r, u, d, l
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.min = Integer.MAX_VALUE; 
        this.minS = null;
        this.hole = hole; 
        this.maze = maze; 
        this.map = new int[maze.length][maze[0].length];
        for(int i = 0; i<map.length; i++) Arrays.fill(map[i], Integer.MAX_VALUE); 
        
        move(ball[0], ball[1], 0, "", -1);
        return (minS==null) ? "impossible" : minS;
    }
    
    private void move(int r, int c, int cnt, String path, int dir){//dir is a index of dirs 
        if(cnt > min || cnt > map[r][c]) return; //not a shortest route for sure 
        if(dir!=-1){//if not from start point 
            //add path 
            if(dir==0) path+='r';
            else if(dir==1) path+='u';
            else if(dir==2) path+='d';
            else path+='l';
    
            //roll along dir 
            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]==0){
                map[r][c] = Math.min(map[r][c], cnt); 
                if(r==hole[0] && c==hole[1]){//check hole
                    if(cnt==min && path.compareTo(minS)<0){
                        minS=path;
                    }else if(cnt<min){
                        min = cnt; 
                        minS = path; 
                    }
                    return; 
                }
                r += dirs[dir][0];
                c += dirs[dir][1];
                cnt++;
            }
            r -= dirs[dir][0];//[r,c] is wall, need to walk back 1 step
            c -= dirs[dir][1];
            cnt--;
        }
        
        //hit wall (or start) -> try to turn
        for(int i = 0; i<dirs.length; i++){
            if(dir == i) continue;//dont keep going
            if(dir == (3-i)) continue;//dont go back
            int newR = r + dirs[i][0];
            int newC = c + dirs[i][1];
            if(newR>=0 && newR<maze.length && newC>=0 && newC<maze[0].length && maze[newR][newC]==0){//can go
                move(r, c, cnt, path, i);
            }
        }
    }
}
