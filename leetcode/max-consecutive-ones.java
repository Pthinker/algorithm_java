485. Max Consecutive Ones

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000


public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        int max=0;
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            if(sum+nums[i] > sum) {
                max = Math.max(max, sum+nums[i]);
                sum += nums[i];
            } else {
                sum = 0;
            }
        }
        return max;
    }
}

////////////////////////////////////////////

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int cnt=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                if (cnt>max) {
                    max=cnt;
                }
                cnt=0;
            } else {
                cnt+=1;
            }
        }
        if(max>cnt) {
            return max;
        } else {
            return cnt;
        }
    }
}