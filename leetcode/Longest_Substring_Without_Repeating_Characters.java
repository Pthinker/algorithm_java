Given a string, find the length of the longest substring without repeating 
characters. For example, the longest substring without repeating letters 
for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest 
substring is "b", with the length of 1.


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

/////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] flag = new boolean[256];
        
        char[] c = s.toCharArray();
        int i=0, j=0, res=0;

        while(i < c.length) {
            if(flag[c[i]] == true) {
                res = Math.max(i-j, res); 
                for(int k=j; k<i; k++) {
                    if(c[k] == c[i]){
                        j = k + 1;
                        break;
                    } 
                    flag[c[k]] = false;
                }
            } else
                flag[c[i]] = true;
            i++;
        }
        res = Math.max(c.length-j, res);
        return res;
    }
}

