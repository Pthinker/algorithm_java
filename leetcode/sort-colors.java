75. Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library''s sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0''s, 1''s, and 2''s, then overwrite array with total number of 0''s, then 1''s and followed by 2''s.

Could you come up with an one-pass algorithm using only constant space?


public class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3]; 
        int idx = 0;
        for(int i=0; i<nums.length; ++i) {
            ++count[nums[i]];
        }
        for(int i=0; i<3; ++i) {
            for (int j=0; j<count[i]; ++j) {
                nums[idx++] = i;
            }
        }
    }
}

//////////////////////////////////////////////////////////

//follow up: scan array once
public class Solution {
    public void sortColors(int[] nums) {
        int head = 0;
        int tail = nums.length-1;
        
        int i=0;
        while(i<=tail) {
            if(nums[i]==0) {
                nums[i]=nums[head];
                nums[head]=0;
                head++;
                i++;
            } else if(nums[i]==2) {
                nums[i]=nums[tail];
                nums[tail]=2;
                tail--;
            } else {
                i++;
            }
        }
    }
}