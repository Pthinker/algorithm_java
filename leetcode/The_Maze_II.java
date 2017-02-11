505. The Maze II

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won''t stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, your job is to find out how the ball could drop into the hole by moving shortest distance in the maze. The distance is defined by the number of empty spaces the ball go through from the start position (exclude) to the hole (include). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there may have several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and hole coordinates are represented by row and column indexes.


public class Solution {
    class Point {
        int x,y,l;
        public Point(int _x, int _y, int _l) {x=_x;y=_y;l=_l;}
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m=maze.length, n=maze[0].length;
        int[][] length=new int[m][n]; // record length
        for (int i=0;i<m*n;i++) length[i/n][i%n]=Integer.MAX_VALUE;
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        PriorityQueue<Point> list=new PriorityQueue<>((o1,o2)->o1.l-o2.l); // using priority queue
        list.offer(new Point(start[0], start[1], 0));
        while (!list.isEmpty()) {
            Point p=list.poll();
            if (length[p.x][p.y]<=p.l) continue; // if we have already found a route shorter
            length[p.x][p.y]=p.l;
            for (int i=0;i<4;i++) {
                int xx=p.x, yy=p.y, l=p.l;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                    l++;
                }
                xx-=dir[i][0];
                yy-=dir[i][1];
                l--;
                list.offer(new Point(xx, yy, l));
            }
        }
        return length[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:length[destination[0]][destination[1]];
    }
}
