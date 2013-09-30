Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "a*") ? true
isMatch("aa", ".*") ? true
isMatch("ab", ".*") ? true
isMatch("aab", "c*a*b") ? true


public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0)
            return p.length()>1 && p.length()%2==0 ? p.charAt(1)== '*'
                && isMatch(s,p.substring(2)) : p.length()==0;
        if(p.isEmpty())
            return false;
        char c1 = s.charAt(0);
        char c2 = p.charAt(0);
        char c2next = p.length()>1? p.charAt(1) : 'x';
        if(c2next == '*'){
            if(isSame(c1,c2)){
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            else return isMatch(s, p.substring(2));
        } else {
            if(isSame(c1, c2))
                return isMatch(s.substring(1), p.substring(1));
            else
            	return false;
        }        
    }
    public boolean isSame(char c1, char c2){
        return c2=='.' || c1==c2;
    }
 
}