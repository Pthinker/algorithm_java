You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1) return 1;
        if(n==2) return 2;
        int[] r = new int[n+1];
        r[1] = 1;
        r[2] = 2;
        for(int i=3; i<=n; i++) {
            r[i] = r[i-1] + r[i-2];
        }
        return r[n];
    }
}

////////////////////////////////////////////////////////////////

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
 	    
 	    if(n==1) return 1;
 	    if(n==2) return 2;
 	    int s2 = 1;
 	    int s1 = 2;
 	    int cur = 0;
 	    for(int i=3; i<=n; i++) {
 	    	cur = s1 + s2;
 	    	s2 = s1;
 	    	s1 = cur;
 	    }
 	    return cur;
    }
}