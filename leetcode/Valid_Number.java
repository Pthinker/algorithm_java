65. Valid Number

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.


//https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
/*
We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
*/
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
    
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }
}

/////////////////////////////////////////////////////////////////////////////

public class Solution {
    public boolean isNumber(String s) {
        char[] tmp = s.toCharArray();
        int[][] trans = {
            { 0 ,0 ,0 ,0 ,0 ,0 },// false
            { 0 ,2 ,3 ,0 ,1 ,4 },// 1
            { 0 ,2 ,5 ,6 ,9 ,0 },// 2
            { 0 ,5 ,0 ,0 ,0 ,0 },// 3
            { 0 ,2 ,3 ,0 ,0 ,0 },// 4
            { 0 ,5 ,0 ,6 ,9 ,0 },// 5
            { 0 ,7 ,0 ,0 ,0 ,8 },// 6
            { 0 ,7 ,0 ,0 ,9 ,0 },// 7
            { 0 ,7 ,0 ,0 ,0 ,0 },// 8
            { 0 ,0 ,0 ,0 ,9 ,0 } // 9
        };
        int i = 0;
        int stat = 1;
        while (i < tmp.length) {
            int type = 0;
            if (tmp[i] >= '0' && tmp[i] <= '9') type = 1;
            else if (tmp[i] == '.') type = 2;
            else if (tmp[i] == 'e') type = 3;
            else if (tmp[i] == ' ') type = 4;
            else if (tmp[i] == '+' || tmp[i] == '-') type = 5;
            stat = trans[stat][type];
            i++;
        }
        return stat == 2 || stat == 5 || stat == 7 || stat == 9;
    }
}

Note:
type    0   1   2   3   4   5    
    others  digits  point   e   space   sign

stat
0   FALSE
1   only space  
2   digits  
3   only point
4   sign    
5   digits. 
6   e   
7   e digits    
8   e sign  
9   valid space
