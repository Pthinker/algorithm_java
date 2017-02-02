3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<1)
            return 0;
        
        int max = 0;
        int start = 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                max = Math.max(max, i-start);
                for(int j=start; j<map.get(s.charAt(i)); j++)
                    map.remove(s.charAt(j));
                start = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i), i);
        }
        
        max = Math.max(s.length()-start, max);
        return max;
    }
}


