375. Guess Number Higher or Lower II

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it''s higher. You pay $5.
Second round: You guess 7, I tell you that it''s higher. You pay $7.
Third round:  You guess 9, I tell you that it''s lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.


Hint:

The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
Take a small example (n = 3). What do you end up paying in the worst case?
Check out this article if you are still stuck.
The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?


//https://www.hrwhisper.me/leetcode-guess-number-higher-lower-ii
//https://harunscorner.wordpress.com/2016/09/04/leetcode-guess-number-higher-or-lower-ii-solution/
//https://discuss.leetcode.com/topic/68252/clarification-on-the-problem-description-problem-description-need-to-be-updated/
//https://discuss.leetcode.com/topic/51353/simple-dp-solution-with-explanation
//Notice we do not need to pay the money for both subproblems. We only need to pay the worst case (because the system will tell us which side we should go) to guarantee win. So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }
}
