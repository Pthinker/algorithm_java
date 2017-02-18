189. Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.



//// time limit exceed
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k==0) return;
        for(int i=0; i<k; i++) {
            int prev=nums[nums.length-1];
            for(int j=0; j<nums.length; j++) {
                int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }
    }
}

////////////////////////////////////////////////////////////////

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

////////////////////////////////////////////////////////////////


public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<=1 || k%(nums.length)==0)
            return;
            
        int i=0;
        int idx=0;
        int n=nums[idx];
        int size = nums.length;
        int start = 0;
        while(i<nums.length) {
            idx=(idx+k)%size;
            int tmp = nums[idx];
            nums[idx] = n;
            if(idx==start) {
                start++;
                idx++;
                n=nums[idx];
            } else {
                n=tmp;
            }
            
            i++;
        }
    }
}


