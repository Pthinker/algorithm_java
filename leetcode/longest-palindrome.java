409. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


public class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) 
            return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count+=2;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count+1;
        return count;
    }
}

/////////////////////////////////////////////////

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        boolean hasOdd = false;
        int len = 0;
        for (Character c : map.keySet()) {
            len += map.get(c);
            if(map.get(c)%2 == 1) {
                hasOdd = true;
                len--;
            }
        }
        
        if(hasOdd) {
            len++;
        }
        
        return len;
    }
}
