81. Search in Rotated Sorted numsrray II

Follow up for "Search in Rotated Sorted numsrray":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.


//https://discuss.leetcode.com/topic/310/when-there-are-duplicates-the-worst-case-is-o-n-could-we-do-better
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) 
            return false;

        int l = 0;
        int r = nums.length - 1;

        while(l<=r) {
            int mid = l + (r - l) / 2;
        	if(nums[mid] == target)
        		return true;

        	if(nums[l] < nums[mid]) {
        		if(nums[l]<=target && target<nums[mid])
        			r = mid - 1;
        		else
        			l = mid + 1;
        	} else if(nums[l] > nums[mid]) {
        		if(nums[mid]<target && target<=nums[r])
        			l = mid + 1;
        		else
        			r = mid - 1;
        	} else {
                l++;   
        	}
        }

        return false;
    }
}