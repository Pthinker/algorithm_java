7. Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer''s last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.



public class Solution {
    public int reverse(int n) {
        long reversed_n = 0;
        
        while (n != 0) {
            reversed_n = reversed_n * 10 + n % 10;
            n = n / 10;
        }
        
        if(reversed_n>Integer.MAX_VALUE || reversed_n<Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int)reversed_n;
    }
}