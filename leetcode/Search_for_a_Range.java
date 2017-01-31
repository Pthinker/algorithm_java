34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


//1.searchRightIndex：查找并返回target出现在nums数组最右边的index。注意一点，如果target比数组最小值还小，那么返回-1
//2.searchLeftIndex：查找并返回target出现在nums数组最左边的index。如果target比数组最大值还大，那么返回nums.length
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};  
        int index = searchRightIndex(nums, 0, nums.length-1, target);
        if (index < 0 || nums[index] != target)
            return result;
        result[0] = searchLeftIndex(nums, 0, index, target);
        result[1] = index;
        return result;
    }
    public int searchRightIndex(int[] nums, int left, int right, int target) {  
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
    public int searchLeftIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right-left) / 2;  
            if (nums[mid] < target) left = mid + 1;  
            else right = mid - 1;  
        }  
        return left;  
    }
}

