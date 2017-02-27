376. Wiggle Subsequence

A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?


//dp
/*
O(n^2)
维护两个dp数组p和q，其中p[i]表示到i位置时首差值为正的摆动子序列的最大长度，q[i]表示到i位置时首差值为负的摆动子序列的最大长度。我们从i=1开始遍历数组，然后对于每个遍历到的数字，再从开头位置遍历到这个数字，然后比较nums[i]和nums[j]，分别更新对应的位置
*/
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        int[] p = new int[nums.length];
        int[] q = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            p[i] = 1;
            q[i] = 1;
        }
        
        for (int i=1; i<nums.length; ++i) {
            for (int j=0; j<i; ++j) {
                if (nums[i] > nums[j]) {
                    p[i] = Math.max(p[i], q[j] + 1);
                } else if (nums[i] < nums[j]) {
                    q[i] = Math.max(q[i], p[j] + 1);
                }
            }
        }
        return Math.max(p[p.length-1], q[q.length-1]);
    }
}

/////////////////////////////

//https://discuss.leetcode.com/topic/52076/easy-understanding-dp-solution-with-o-n-java-version
//O(n)
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if( nums.length == 0 ) return 0;
        
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        
        up[0] = 1;
        down[0] = 1;
        
        for(int i = 1 ; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if( nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        
        return Math.max(down[nums.length-1],up[nums.length-1]);
    }
}

/////////////////////////////

//https://discuss.leetcode.com/topic/52153/java-greedy-solution-o-n-time-complexity-o-1-space-complexity
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int f = 1, b = 1; //the first number can be a smaller number or larger number depends on what the next number it is. 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) f = b + 1;
            else if (nums[i] < nums[i-1]) b = f + 1;
        }
        return Math.max(f, b);
    }
}

