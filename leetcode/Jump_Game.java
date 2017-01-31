55. Jump Game

Given an array of non-negative integers, you are initially positioned at the 
first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


public class Solution {
    public boolean canJump(int[] A) {
        if(A.length <= 1)
            return true;
     
        int max = A[0]; //max stands for the largest index that can be reached.
     
        for(int i=0; i<A.length; i++){
            //if not enough to go to next
            if(max <= i && A[i] == 0) 
                return false;
     
            //update max    
            if(i + A[i] > max){
                max = i + A[i];
            }
     
            //max is enough to reach the end
            if(max >= A.length-1) 
                return true;
        }
     
        return false;    
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public boolean canJump(int[] A) {
        if(A==null || A.length==0)
            return false;
        
        if(A.length==1)
            return true;
        
        int[] jump = new int[A.length];
        jump[0] = 0;
        
        for(int i=1; i<A.length; i++) {
            jump[i] = Math.max(A[i-1], jump[i-1]) - 1;
            if(jump[i]<0)
                return false;
        }
        
        return jump[A.length-1] >= 0;
    }
}

////////////////////////////////////////////////////////////////////////

//O(n)
public class Solution {
    public boolean canJump(int[] A) {
        if(A==null || A.length==0)
            return false;
        
        if(A.length==1)
            return true;
        
        int maxCover = 0;
        for(int i=0; i<=maxCover && i<A.length; i++) {
            if(A[i] + i > maxCover) {
                maxCover = A[i] + i;
                if(maxCover>=A.length-1)
                    return true;
            }
        }
        
        return false;
    }
}
