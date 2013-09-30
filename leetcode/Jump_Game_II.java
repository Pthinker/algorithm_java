Given an array of non-negative integers, you are initially positioned at 
the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step 
	from index 0 to 1, then 3 steps to the last index.)

 
// Time Limit Exceeded for large dataset
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)
            return 0;
        
        int[] res = new int[A.length];
        res[0] = 0;
        
        for(int i=1; i<res.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<i; j++) {
                if(A[j] >= i-j)
                    if(res[j] + 1 < min)
                        min = res[j] + 1;
            }
            if(min == Integer.MAX_VALUE)
                return 0;
            else
                res[i] = min;
        }
        return res[res.length-1];
    }
}


