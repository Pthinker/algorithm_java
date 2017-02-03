446. Arithmetic Slices II - Subsequence

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A.

The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.

//使用动态规划来解这道题。假设dp[i][j]表示以A[i]结尾的子序列(P0, P1, …, Pi)构成的数列，序列中的元素之差为j。而dp[i][j]=dp[k][j]>0?dp[k][j]+1:1，0<=i<A.length()，0<=k<i。其中dp[k][j]为0的时候需要加1，也就是仅存在两个数的数列时dp[i][j]需要加1，这是因为再之后第3个数匹配时可以形成一个正确数列，然后1加到总数里。
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	int re = 0;
    	HashMap<Integer, HashMap<Long, Integer>> diffMaps = new HashMap<>();
    	for (int i = 0; i < A.length; i++) {
    		HashMap<Long, Integer> diffMap = new HashMap<>();
    		diffMaps.put(i, diffMap);
    		int num = A[i];
    		for (int j = 0; j < i; j++) {
    			if ((long) num - A[j] > Integer.MAX_VALUE)
    				continue;
    			if ((long) num - A[j] < Integer.MIN_VALUE)
    				continue;
    			long diff = (long) num - A[j];
    			int count = diffMaps.get(j).getOrDefault(diff, 0);
    			diffMaps.get(i).put(diff, diffMaps.get(i).getOrDefault(diff, 0) + count + 1);
    			re += count;
    		}
    	}
    	return re;
    }
}