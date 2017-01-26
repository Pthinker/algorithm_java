290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split("\\s+");
        if(pattern.length()!=arr.length) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = arr[i];
            
            if(map.containsKey(c)) {
                if (!map.get(c).equals(s)) {
                    return false;
                }
            } else {
                if(set.contains(s)) {
                    return false;
                }
                map.put(c, s);
                set.add(s);
            }
        }
        return true;
    }
}

