Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321


public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        boolean neg = false;
        if(x<0) {
            x = -x;
            neg = true;
        }
        
        int res = 0;
        while(x>0) {
            int tmp = x%10;
            res = res*10 + tmp;
            x /= 10;
        }
        
        if(neg)
            res = -res;
    
        return res;
    }
}

///////////////////////////////////////////////////////////////

public class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        
        int result = 0;
        while( num > 0 ) {
            int r = num - num / 10 * 10;
            result = result * 10 + r;
            num /= 10;
        }
        
        if(x<0)
            return -result;
        else
            return result;
    }
}