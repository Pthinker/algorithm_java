80. Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].


public class Solution {
    public int removeDuplicates(int[] A) {
		if(A==null || A.length==0) return 0;
		if(A.length==1) return 1;

		int cur = 1;
		int count = 1;
		int prev = A[0];
    	for(int i=1; i<A.length; i++) {
    		if(A[i]!=prev) {
    			A[cur] = A[i];
    			cur++;
    			prev = A[i];
    			count = 1;
    		} else if(A[i]==prev && count<2) {
    			A[cur] = A[i];
    			cur++;
    			count++;
    		} 
    	}    
    	return cur;
    }
}

