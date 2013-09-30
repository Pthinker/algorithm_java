Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were 
inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0



public class Solution {
    public int searchInsert(int[] A, int target) {
        int l = 0;
        int r = A.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(A[mid]==target)
                return mid;
            else if(A[mid]>target) 
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)
            return 0;
        
        for(int i=0; i<A.length; i++) {
            if(A[i]>=target)
                return i;
        }
        
        return A.length;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below (or maybe above?)
        // DO NOT write main() function, you sure???
        int right = A.length - 1;
        int left = 0;

        int index = 0;
        while(left <= right) {
            int middle = left + (right - left) / 2;
        	  if(A[middle] == target) {
        		    index = middle;
                break;
        	  } else if(A[middle] < target) {
        		    left = middle + 1;
        		    index = left;
        	  } else {
        		    right = middle - 1;
        	  }  
        }
        return index;
    }
}

