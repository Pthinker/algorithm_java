476. Number Complement

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.


//从高往低遍历，如果遇到第一个1了后，我们的flag就赋值为true，然后就可以进行翻转了，翻转的方法就是对应位异或一个1即可
public class Solution {
    public int findComplement(int num) {
        boolean start = false;
        for (int i=31; i>=0; --i) {
            if((num & (1 << i)) > 0) {
                start=true;
            }
            if(start) {
                num ^= (1 << i);
            }
        }
        return num;
    }
}

//////////////////////////////////////////