268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?



public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        return n * (n + 1)/2 - sum;
    }
}

/////////////////////////////////////////////
//将这个少了一个数的数组合0到n之间完整的数组异或一下，那么相同的数字都变为0了，剩下的就是少了的那个数字了
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length; ++i) {
            res ^= (i+1) ^ nums[i];
        }
        return res;
    }
}