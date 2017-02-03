5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"


// DP, O(n^2) time and space
public class Solution {
    public String longestPalindrome(String s) {
        int begin = 0;
        int end = 0;
        int max = 1;
        int len = s.length();
        
        boolean[][] matrix = new boolean[len][len];
        
        for(int i=0; i<len; i++)
            matrix[i][i] = true;
        
        for(int i=0; i<len-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                matrix[i][i+1] = true;
                if(2>max) {
                    begin = i;
                    end = i+1;
                    max = 2;
                }
            }
        }
        
        for(int n=3; n<=len; n++) {
            for(int i=0; i<len-n+1; i++) {
                int j = i + n - 1;
                if(s.charAt(i)==s.charAt(j) && matrix[i+1][j-1]) {
                    matrix[i][j] = true;
                    begin = i;
                    end = j;
                }
            }
        }
        
        return s.substring(begin, end+1);
    }
}

////////////////////////////////////////////////////////////////////////
//http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
//O(N^2) time and O(1) space
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String longest = s.substring(0, 1);
        
        for(int i=0; i<len-1; i++) {
            String p1 = expandAroundCenter(s, i, i);
            if (p1.length() > longest.length())
                longest = p1;
            
            String p2 = expandAroundCenter(s, i, i+1);
            if (p2.length() > longest.length())
                longest = p2;
        }
        
        return longest;
    }
    
    public String expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
        int n = s.length();
        while (l>=0 && r<=n-1 && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
