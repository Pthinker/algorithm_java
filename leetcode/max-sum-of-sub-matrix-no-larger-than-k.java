363. Max Sum of Rectangle No Larger Than K

Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

Note:
The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?


public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;
        
        int M = Math.max(m, n);
        int N = Math.min(m, n);
        
        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];
            for (int y = x; y < N; y++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int num = 0;
                for (int z = 0; z < M; z++) {
                    sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                    num += sums[z];
                    if (num <= k) ans = Math.max(ans, num);
                    Integer i = set.ceiling(num - k);
                    if (i != null) ans = Math.max(ans, num - i);
                    set.add(num);
                }
            }
        }
        return ans;
    }
}
