462. Minimum Moves to Equal Array Elements II

Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array''s length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]


//https://discuss.leetcode.com/topic/66557/java-o-n-solution-short
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}

/////////////////////////////////

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int median = nums[nums.length/2];
        for(int num:nums) 
            sum += Math.abs(median - num);
        return sum;
    }
}

//mine
public class Solution {
    public int minMoves2(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int mid = (nums.length-1)/2;
        int res = 0;
        for(int num: nums) {
            res += Math.abs(num-nums[mid]);
        }
        return res;
    }
}

/////////////////////////////////

//https://discuss.leetcode.com/topic/68758/java-o-n-time-using-quickselect
//o(n): use quick select to find median
public class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0;
        int median = findMedian(nums);
        for (int i=0;i<nums.length;i++) {
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }
    
    public int findMedian(int[] nums) {
        return getKth(nums.length/2+1, nums, 0, nums.length - 1);
    }
    
    public int getKth(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
    
        while (true) {
            while (nums[left] < pivot && left < right) left++;
            while (nums[right] >= pivot && right > left) right--;
            if (left == right) break;
            swap(nums, left, right);
        }
    
        swap(nums, left, end);
        if (k == left + 1)  return pivot;
        else if (k < left + 1) return getKth(k, nums, start, left - 1);
        else return getKth(k, nums, left + 1, end);
    }
    
    public void swap(int[] nums, int n1, int n2) {
    	int tmp = nums[n1];
    	nums[n1] = nums[n2];
    	nums[n2] = tmp;
    }
}