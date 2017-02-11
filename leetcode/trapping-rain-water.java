42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


//https://discuss.leetcode.com/topic/5125/sharing-my-simple-c-code-o-n-time-o-1-space
/*
Here is my idea: instead of calculating area by height*width, we can think it in a cumulative way. In other words, sum water amount of each bin(width=1).
Search from left to right and maintain a max height of left and right separately, which is like a one-side wall of partial container. Fix the higher one and flow water from the lower part. For example, if current height of left is lower, we fill water in the left bin. Until left meets right, we filled the whole container.
*/
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxleft) 
                	maxleft=height[left];
                else 
                	res+=maxleft-height[left];
                left++;
            }
            else {
                if(height[right]>=maxright) 
                	maxright= height[right];
                else 
                	res+=maxright-height[right];
                right--;
            }
        }
        return res;
    }
}

//////////////////////////////////////////

//dp
//http://www.sigmainfy.com/blog/leetcode-trapping-rain-water.html
public class Solution {
    public int trap(int[] height) {
        int res = 0, mx = 0, n = height.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i]= mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            mx = Math.max(mx, height[i]);
            dp[i] = Math.min(dp[i], mx);
            if (dp[i]-height[i] > 0) res += dp[i] - height[i];
        }
        return res;
    }
}

// a little improvement, using one additional array
public class Solution {
    public int trap(int[] height) {
        int res = 0, mx = 0, n = height.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i]= mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            mx = Math.max(mx, height[i]);
            dp[i] = Math.min(dp[i], mx);
            res += dp[i] - height[i];
        }
        return res;
    }
}


