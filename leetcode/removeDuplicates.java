Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) {
            return nums.length;
        }
        
        int curr=0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[curr]) {
                int tmp = nums[curr+1];
                nums[curr+1] = nums[i];
                nums[i] = tmp;
                curr++;
            }
        }
        return curr+1;
    }
}

///////////////////////////////////////////////////////////////////////////

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<2)
            return A.length;
        
        int prev = 0;
        for(int i=1; i<A.length; i++) {
            if(A[i]!=A[prev]) {
                prev += 1;
                A[prev] = A[i];
            }
        }
        
        return prev + 1;
    }
}
