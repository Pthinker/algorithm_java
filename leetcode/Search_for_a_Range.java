Given a sorted array of integers, find the starting and ending position of 
a given target value.

Your algorithm runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


public class Solution {  
    public int[] searchRange(int[] A, int target) {       
        int[] res = {-1, -1};
        if(A==null || A.length==0) 
            return res;
            
        int left = 0, right = A.length-1;
        while(left <= right) {  
            int mid = (left+right)/2;  
            if(target > A[mid]) 
                left = mid+1;  
            else 
                right = mid-1;  
        }
        
        if(left<0 || left>=A.length || A[left]!=target) 
            return res;
            
        res[0] = left;  
        right = A.length-1;  
        while(left <= right) {  
            int mid = (left+right)/2;  
            if(target < A[mid]) 
                right = mid-1;  
            else 
                left = mid+1;  
        }  
        res[1] = right;  
        return res;  
    }  
}

