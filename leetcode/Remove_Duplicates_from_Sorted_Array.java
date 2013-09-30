Given a sorted array, remove the duplicates in place such that each element 
appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place 
with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].


public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<2)
            return A.length;
        
        int prev = 0;
        for(int i=1; i<A.length; i++) {
            if(A[i]!=A[prev]) {
                prev += 1;
                A[prev] = A[i];
            }
        }
        
        return prev + 1;
    }
}

//////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)
            return 0;
            
        int tail = 0;

        for(int cur=1; cur<A.length; cur++) {
            if(A[cur]!=A[tail]) {
                tail++;
                A[tail] = A[cur];
            }
        }

        return tail+1;
    }
}

