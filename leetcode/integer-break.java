343. Integer Break

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Hint:
There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.


//DP
//https://segmentfault.com/a/1190000005763103
//dp[i] = Max(dp[k] * dp[i - k], k * (i - k), dp[k] * (i - k), k * (dp[i - k])), k取值从[1, i / 2]闭区间
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int k = 1; k <= i / 2; k++) {
                int tmpMax = Math.max(dp[k] * dp[i-k], k * (i-k));
                tmpMax = Math.max(tmpMax, dp[k] * (i-k));
                tmpMax = Math.max(tmpMax, dp[i-k] * k);
                max = Math.max(tmpMax, max);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}

//http://www.cnblogs.com/grandyang/p/5411919.html
//math
public class Solution {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}

