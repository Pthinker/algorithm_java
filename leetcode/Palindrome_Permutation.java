266. Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.


public class Solution {  
    public boolean canPermutePalindrome(String s) {  
        HashMap<Character, Integer> d = new HashMap<>();  
        for(int i = 0; i < s.length(); i++) {  
            if(d.containsKey(s.charAt(i)))  
                d.put(s.charAt(i), d.get(s.charAt(i)) + 1);  
            else  
                d.put(s.charAt(i), 1);  
        }  
          
        boolean already = false;  
        for(Character i : d.keySet()) {  
            if(d.get(i) % 2 != 0) {  
                if(already)  
                    return false;  
                else  
                    already = true;  
            }  
        }  
        return true;  
    }  
}
