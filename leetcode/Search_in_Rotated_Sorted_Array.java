33. Search in Rotated Sorted numsrray

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.


public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        
        while(l<=r) {
            int mid = (l + r) / 2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] > target) {
                if(nums[mid] >= nums[l]) {
                    if(nums[l]<=target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    r = mid - 1;
                }
            } else {
                if(nums[mid] <= nums[r]) {
                    if(nums[r]>=target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    l = mid + 1;
                }
            }
        }    
        
        return -1;
    }
}

////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null) 
            return -1;

        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
        	int mid = l + (r - l) / 2;
        	if(nums[mid] == target)
        		return mid;

        	if(nums[l] <= nums[mid]) {
        		if(nums[l]<=target && target<nums[mid])
        			r = mid - 1;
        		else
        			l = mid + 1;
        	} else {
        		if(nums[mid]<target && target<=nums[r])
        			l = mid + 1;
        		else
        			r = mid - 1;
        	}
        }

        return -1;
    }
}
