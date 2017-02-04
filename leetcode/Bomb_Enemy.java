361. Bomb Enemy

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)


public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Spot[][] spots = new Spot[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                spots[i][j] = new Spot();
                if (grid[i][j] == 'W') {
                    continue;
                }
                spots[i][j].up = (i == 0 ? 0 : spots[i - 1][j].up) + (grid[i][j] == 'E' ? 1 : 0);
                spots[i][j].left = (j == 0 ? 0 : spots[i][j - 1].left) + (grid[i][j] == 'E' ? 1 : 0);
            }
        }
        
        int maxKill = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                spots[i][j].bottom = (i == m - 1 ? 0 : spots[i + 1][j].bottom) + (grid[i][j] == 'E' ? 1 : 0);
                spots[i][j].right = (j == n - 1 ? 0 : spots[i][j + 1].right) + (grid[i][j] == 'E' ? 1 : 0);
                
                if (grid[i][j] == '0') {
                    maxKill = Math.max(maxKill, spots[i][j].up + spots[i][j].left + spots[i][j].bottom + spots[i][j].right);
                }
            }
        }
        return maxKill;
    }
}

class Spot {
    int up; // enemies to its up including itself
    int left; // enemies to its left including itself
    int bottom;
    int right;
}