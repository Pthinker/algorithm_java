242. Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


public boolean isAnagram(String s, String t) {
	if(s.length()!=t.length())
        return false;
 
    int[] arr = new int[26];
    for(int i=0; i<s.length(); i++){
        arr[s.charAt(i)-'a']++;
        arr[t.charAt(i)-'a']--;
    }
 
    for(int i : arr) {
        if(i!=0)
            return false;
    }
 
    return true;
}

////////////////////////////////////////////////////////////////////////////////////
If the inputs contain unicode characters, an array with length of 26 is not enough. Then use hashmap


public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        for(int i=0; i<t.length(); i++) {
            if(!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if(map.get(t.charAt(i))<0) {
                    return false;
                }
            }
        }
        return true;
    }
}
