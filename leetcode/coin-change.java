322. Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.


public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {
                if(coin<=i) {
                    if(dp[i-coin]!=Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-coin]+1);
                    }
                }
            }
        }
        
        return dp[amount]==Integer.MAX_VALUE? -1 : dp[amount];
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<dp.length-1; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for(int coin : coins) {
                if( (i+(long)coin) <= (dp.length-1)) {
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                }
            }
        }
        
        return dp[dp.length-1]==Integer.MAX_VALUE? -1 : dp[dp.length-1];
    }
}
