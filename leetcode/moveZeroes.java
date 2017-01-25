Given an array nums, write a function to move all 0 to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.


public class Solution {
    public void moveZeroes(int[] nums) {
        int curr = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                if(curr<0) {
                    curr=i;
                }
            } else {
                if(curr>=0) {
                    nums[curr] = nums[i];
                    nums[i]=0;
                    curr+=1;
                }
            }
        }
    }
}


public class Solution {
    public void moveZeroes(int[] nums) {
        int curr=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                int tmp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = tmp;
                curr++;
            }
        }
    }
}