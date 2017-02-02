454. 4Sum II

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0


public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int n = A.length;
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j) {
                int sum = A[i] + B[j];
                if(m1.containsKey(sum)) {
                    m1.put(sum, m1.get(sum)+1);
                } else {
                    m1.put(sum, 1);
                }

                sum = C[i] + D[j];
                if(m2.containsKey(sum)) {
                    m2.put(sum, m2.get(sum)+1);
                } else {
                    m2.put(sum, 1);
                }
            }
        }
        for (int a : m1.keySet()) {
            if(m2.containsKey(-a)) {
                res += m1.get(a) * m2.get(-a);
            }
        }
        return res;
    }
}
