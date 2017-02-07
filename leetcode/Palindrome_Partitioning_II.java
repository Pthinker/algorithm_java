
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


public class Solution {
    public int minCut(String s) {
        int length = s.length();
        
        boolean[][] matrix = new boolean[length][length];
        for(int i=0; i<length; i++)
            matrix[i][i] = true;
        for(int i=0; i<length-1; i++) {
            if(s.charAt(i)==s.charAt(i+1))
                matrix[i][i+1] = true;
        }
        for(int len=3; len<=length; len++) {
            for(int i=0; i<=length-len; i++) {
                int j = i + len - 1;
                if(s.charAt(i)==s.charAt(j) && matrix[i+1][j-1])
                    matrix[i][j] = true;
            }
        }

        int[] dp = new int[length];
        dp[0] = 0;
        
        for(int i=1; i<s.length(); i++) {
            dp[i] = i;
            if(matrix[0][i]) {
                dp[i] = 0;
                continue;
            }
            
            for(int j=0; j<i; j++) {
                if(matrix[j+1][i]) {
                    dp[i] = Math.min(dp[i], 1+dp[j]);
                }
            }
        }
        return dp[length-1];
    }
}
