395. Longest Substring with At Least K Repeating Characters

Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


//先统计出字符串中每个字符出现的次数，对于出现次数少于k的字符，任何一个包含该字符的字符串都不是符合要求的子串，因此这样的字符就是分隔符，应该以这些出现次数少于k次的字符做分隔符打断原字符串，然后对各个打断得到的字符串进行递归统计，得到最长的符合要求的字符串。如果一个字符串中不包含分隔符(即每个字符出现的次数都达到了k次及以上次数)，那么这个字符串就是符合要求的子串。
public class Solution {
    public int longestSubstring(String s, int k) {
        return dc(s, 0, s.length()-1, k);
    }
        
    public int dc(String s, int start, int end, int k) {
        if (end-start+1 < k) return 0;
        
        int[] cnt = new int[26];
        for (int i=start; i<=end; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        
        for (int i=start; i<=end; i++) {
            if (cnt[s.charAt(i)-'a'] < k) {
                return Math.max(dc(s, start, i-1, k), dc(s, i+1, end, k));
            }
        }
        return end-start+1;
    }
}

