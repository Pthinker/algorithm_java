11. Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


//需要定义i和j两个指针分别指向数组的左右两端，然后两个指针向中间搜索，每移动一次算一个值和结果比较取较大的，容器装水量的算法是找出左右两个边缘中较小的那个乘以两边缘的距离
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

///////////////////////////////////////////////////////////////

//小幅度的优化，对于相同的高度们直接移动i和j就行了，不再进行计算容量了
public class Solution {
    public int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            while (i < j && h == height[i]) ++i;
            while (i < j && h == height[j]) --j;
        }
        return res;
    }
}
