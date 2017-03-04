29. Divide Two Integers

Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.


//https://discuss.leetcode.com/topic/45980/very-detailed-step-by-step-explanation-java-solution
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? 0-result: result;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && (divisor == 1 || divisor == -1)){
            return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int)divideLong(dividend, divisor);
    }
    
    public long divideLong(long dd, long dv){
        boolean isPos = (dd > 0 && dv > 0) || (dd < 0 && dv < 0); 
        dd = Math.abs(dd);
        dv = Math.abs(dv);
        int digits = 0;
        // 通过将除数乘2，乘4，乘8，一直乘下去，找到商的最高的次方
        // 比如87/4=21，商的最高次方是4，即2^4=16，即4 * 16 < 87
        while(dv <= dd){
            dv <<= 1;
            digits++;
        }
        // 重置除数，把最高次方减1得到实际最高位，刚才循环中多加了一次
        long res = 0;
        dv >>= digits;
        digits--;
        // 看商的每一位是否应该为1
        while(digits >= 0){
            if(dd >= (dv << digits)){
                dd -= dv << digits;
                res += 1 << digits;
            }
            digits--;
            System.out.println(res);
        }
        return isPos ? res : - res;
    }
}