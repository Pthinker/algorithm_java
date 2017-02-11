213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.



//如果我们把第一家和最后一家分别去掉，各算一遍能抢的最大值，然后比较两个值取其中较大的一个即为所求
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
    public int rob(int[] nums, int lo, int hi) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = lo; i <= hi; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);
            
            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob, notRob);
    }
}