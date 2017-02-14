371. Sum of Two Integers

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.


//https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
//首先，我们通过对x和y进行&位运算，得出每一位上的进位。然后对x和y进行^位运算，得出没有加进位的和。最后将所得的和当做新的x，所得的进位往左移一位(第零位的进位输入为0)当做新的y，继续做上面的步骤，直到进位为0，此时x中保存的就是我们要求的x和y的和了
public class Solution {
    public int getSum(int a, int b) {
        while(b!=0) {
            int c = a&b;
            a=a^b;
            b=c<<1;
        }
        return a;
    }
}