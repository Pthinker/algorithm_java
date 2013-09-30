Given n non-negative integers a1, a2, ..., an, where each 
represents a point at coordinate (i, ai). n vertical lines are drawn 
such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains 
the most water.

Note: You may not slant the container.

// brute force method, time limit exceeded 
public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height==null || height.length==0) return 0;

        int max = 0;
        for(int i=0; i<height.length; i++) {
        	for(int j=i+1; j<height.length; j++) {
        		int h = height[i]>height[j]?height[j]:height[i];
        		int area = (j - i) * h;
        		if(area > max)
        			max = area; 
        	}
        }

        return max;
    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length==0) return 0;
        int max = 0;
    	int l = 0;
    	int r = height.length - 1;

    	while(l < r) {
    		int area = (r - l) * Math.min(height[l], height[r]);
    		if(area > max)
    			max = area;

    		if(height[l] < height[r]) {
    			l++;
    		} else {
    			r--;
    		}
    	}
    	return max;
  	}
}

