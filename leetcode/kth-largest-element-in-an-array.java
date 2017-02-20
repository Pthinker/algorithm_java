215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array''s length.


// O(nlogk), heap
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size()>k) p.poll();
        }
        return p.poll();
    }
}

///////////////////////////////////////////////////////////////

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return getKth(nums.length-k+1, nums, 0, nums.length-1);
    }
    
    public int getKth(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;

        while (left<right) {
            while (nums[left] < pivot && left < right) left++;
            while (nums[right] >= pivot && right > left) right--;
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

//quick select: Avg O(N) Worst O(N^2) 空间 O(1)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k);
    }
     
    private int findKthLargestHelper(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return nums[lo];
        }
         
        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return nums[k];
        }
         
        if (pivot > k) {
            return findKthLargestHelper(nums, lo, pivot - 1, k);
        } else {
            return findKthLargestHelper(nums, pivot + 1, hi, k);
        }
    }
     
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
         
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
             
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
             
            if (i <= j) {
                swap(nums, i, j);
            }
        }
         
        swap(nums, lo, j);
         
        return j;
    }
     
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
