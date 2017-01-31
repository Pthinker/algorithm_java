209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there is not one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = 0, sum = 0, minLen = nums.length + 1;
        while(right <= nums.length && left <= right){
            if(sum < s){
                // 当右边界等于长度时，我们要多等一轮，等待左边界左移，这时候不能加
                if(right < nums.length){
                    sum += nums[right];
                }
                right++;
            } else {
                // 当和大于等于目标时，检查长度并左移边界
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLen <= nums.length ? minLen : 0;
    }
}
