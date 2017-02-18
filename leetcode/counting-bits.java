338. Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1''s in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

Hint:
You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?


/*
每个数字的二进制1的个数相当于他右移一位的数字的1的个数加上其二进制表示的最右端数字
举例：
5： 101
10： 1010 右移一位为101，加上0，为2个
11： 1011 右移一位为101，加上1，为3个
23： 10111 右移一位为1011，加上1，为4个
*/
public class Solution {
    public int[] countBits(int num) {
        if(num < 0) return new int[]{0};
        int[] result = new int[num + 1];
        result[0] = 0;
        if(num > 0)
            result[1] = 1;
        for(int i = 2; i<=num; i++)
            result[i] = result[i>>1] + (i&1);
        return result;
    }
}