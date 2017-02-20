378. Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.


public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], h = matrix[n-1][n-1];
        while (l < h) {
            int m = l + (h - l)/2;
            int count = binarySearch(matrix, m);
            if (count < k) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
    public int binarySearch(int[][] matrix, int target) {
        int n = matrix.length, i = n-1, j = 0;
        int res = 0;
        while (i >= 0 && j <= n-1) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
                res += i + 1;
            }
        }
        return res;
    }
}

/////////////////////////////////////////////////////////

//https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code
//heap
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}


