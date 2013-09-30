Divide two integers without using multiplication, division and mod operator.


public class Solution {
    public int divide(int dividend, int divisor) {
        assert(divisor != 0);
        if (dividend == 0)
            return 0;
        
        boolean negative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negative = true;
        }
        
        int result = 0;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        while (lDividend >= lDivisor) {
            long d = lDivisor;
            int temp = 1;
            while (lDividend >= d << 1) {
                d = d << 1;
                temp = temp << 1;
            }
            lDividend -= d;
            result += temp;
        }
        
        if (negative) 
        	return -result;
        else 
        	return result;
    }
}
