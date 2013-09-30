Given n non-negative integers representing the histogram bar height where the 
width of each bar is 1, find the area of largest rectangle in the histogram.


public class Solution {
	public int largestRectangleArea(int[] height) {
          // Start typing your Java solution below
          // DO NOT write main() function
          int[] min = new int[height.length];
          int maxArea = 0;
          for(int i = 0; i < height.length; i++){
              if(height[i] != 0 && maxArea/height[i] >= (height.length - i)) {
                  continue;
              }
             for(int j = i; j < height.length; j++){
                 if(i == j) 
                 	min[j] = height[j];
                 else {
                     if(height[j] < min[j - 1]) {
                         min[j] = height[j];
                     }else min[j] = min[j-1];
                 }
                 int tentativeArea = min[j] * (j - i + 1);
                 if(tentativeArea > maxArea) {
                     maxArea = tentativeArea;
                 }
             }
        }
        return maxArea;
    }
}

//////////////////////////////////////////////////////////////////////////

public class Solution {
 	public int largestRectangleArea2(int[] height) {
          Stack<Integer> stack = new Stack<Integer>();
          int i = 0;
          int maxArea = 0;
          int[] h = new int[height.length + 1];
          h = Arrays.copyOf(height, height.length + 1);
          while(i < h.length){
              if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                  stack.push(i++);
             }else {
                 int t = stack.pop();
                 maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
             }
         }
         return maxArea;
     }
 }
