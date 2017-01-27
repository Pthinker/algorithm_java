459. Repeated Substring Pattern

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int n = str.length();
        for (int i=n/2; i>=1; --i) {
            if (n%i == 0) {
                int c = n/i;
                StringBuffer sb = new StringBuffer();
                for(int j=0; j<c; j++) {
                    sb.append(str.substring(0, i));
                }
                if(sb.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}


/////////////////////////////////////////////////////////////////


下面这种方法是参考的网上的这个帖子，原作者说是用的KMP算法，LeetCode之前也有一道应用KMP算法来解的题Shortest Palindrome，但是感觉那道题才是KMP算法。这道题也称为KMP算法感觉怪怪的(关于KMP的详细介绍请参见从头到尾彻底理解KMP)，KMP算法中的next数组是找当前位置的最大相同前缀后缀的个数，而这道题维护的一位数组dp[i]表示，到位置i-1为止的重复字符串的字符个数，不包括被重复的那个字符串，什么意思呢，我们举个例子，比如"abcabc"的dp数组为[0 0 0 0 1 2 3]，dp数组长度要比原字符串长度多一个。那么我们看最后一个位置数字为3，就表示重复的字符串的字符数有3个。如果是"abcabcabc"，那么dp数组为[0 0 0 0 1 2 3 4 5 6]，我们发现最后一个数字为6，那么表示重复的字符串为“abcabc”，有6个字符。那么怎么通过最后一个数字来知道原字符串是否由重复的子字符串组成的呢，首先当然是最后一个数字不能为0，而且还要满足dp[n] % (n - dp[n]) == 0才行，因为n - dp[n]是一个子字符串的长度，那么重复字符串的长度和肯定是一个子字符串的整数倍，参见代码如下：

 

解法二：

复制代码
class Solution {
public:
    bool repeatedSubstringPattern(string str) {
        int i = 1, j = 0, n = str.size();
        vector<int> dp(n + 1, 0);
        while (i < n) {
            if (str[i] == str[j]) dp[++i] = ++j;
            else if (j == 0) ++i;
            else j = dp[j];
        }
        return dp[n] && (dp[n] % (n - dp[n]) == 0);
    }
};