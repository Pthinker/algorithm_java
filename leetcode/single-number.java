136. Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



//The key to solve this problem is bit manipulation. XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0. Finally only one number left.

public class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
    	for (int a : nums) {
    		x = x ^ a;
    	}
    	return x;
    }
}