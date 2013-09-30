Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.


// C++

class Solution {
public:
    bool isNumber(const char *s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        while (*s == ' ')
            s++;
         
        if (*s == '+' || *s == '-')
            s++;
             
        bool bNum = false;
        while (*s >= '0' && *s <= '9')
        {
            bNum = true;
            s++;
        }
         
        if (*s == '.')
        {
            s++;
            while (*s >= '0' && *s <= '9')
            {
                bNum = true;
                s++;
            }
        }
         
        if (!bNum) 
            return false;
         
        if (*s == 'e')
        {
            s++;
             
            if (*s == '+' || *s == '-')
                s++;
             
            bNum = false;
            while (*s >= '0' && *s <= '9')
            {
                bNum = true;
                s++;
            }
             
            if (!bNum) 
                return false;
        }
         
        while (*s == ' ') 
            s++;
         
        return *s == 0;
    }
};

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
