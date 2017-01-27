28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0) {
            return 0;
        } else if(haystack.length()==0) {
            return -1;
        } else if(needle.length()==0) {
            return 0;
        }
        
        for(int i=0; i<=(haystack.length()-needle.length()); i++) {
            if(haystack.charAt(i)==needle.charAt(0)) {
                boolean match = true;
                for(int j=i+1; j<i+needle.length(); j++) {
                    if(haystack.charAt(j) != needle.charAt(j-i)) {
                        match = false;
                        break;
                    }
                }
                if(match) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}
