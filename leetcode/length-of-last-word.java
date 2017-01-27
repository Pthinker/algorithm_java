58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

Subscribe to see which companies asked this question


public class Solution {
    public int lengthOfLastWord(String s) {
        int right = s.length()-1;
        int res = 0;
        while (right >= 0 && s.charAt(right) == ' ') {
            --right;
        }
        while (right >= 0 && s.charAt(right) != ' ' ) {
            --right; 
            ++res;
        }
        return res;
    }
}
