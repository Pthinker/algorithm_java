Given n, how many structurally unique BST's (binary search trees) that 
store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


// recursion
public class Solution {
    public int numTrees(int n) {
        if(n<1)
            return 1;
        
        return solve(1, n);
    }
    
    public int solve(int l, int r) {
        if(l>r)
            return 1;
        
        int sum = 0;
        for(int i=l; i<=r; i++) {
            sum += solve(l, i-1) * solve(i+1, r);
        }
        return sum;
    }
}

////////////////////////////////////////////////////////////////////////

// DP
public class Solution {
    public int numTrees(int n) {
        int[] nways = new int[n+1];
        nways[0] = 1;
        nways[1] = 1;
        
        for(int i=2; i<=n; i++) {
            int sum = 0;
            for(int root_idx=1; root_idx<=i; root_idx++) {
                int lways = nways[root_idx-1];
                int rways = nways[i-root_idx];
                sum += lways * rways;
            }
            nways[i] = sum;
        }
        
        return nways[n];
    }
}

