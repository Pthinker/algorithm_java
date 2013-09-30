Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.


public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null) 
            return false;

        int l = 0;
        int r = A.length - 1;

        while(l<=r) {
            int mid = l + (r - l) / 2;
        	if(A[mid] == target)
        		return true;

        	if(A[l] < A[mid]) {
        		if(A[l]<=target && target<A[mid])
        			r = mid - 1;
        		else
        			l = mid + 1;
        	} else if(A[l] > A[mid]) {
        		if(A[mid]<target && target<=A[r])
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