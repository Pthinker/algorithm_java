475. Heaters

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.


//先将取暖器数组排序，在遍历所有house，对每个house，在取暖器数组中进行binary search，如果命中，则说明取暖器位置和house位置重合，这个house的最小半径为0；如果没有命中，则使用返回的index，将index左边和右边的取暖器坐标与house坐标求差值，找出这个house最小半径。说白了，也是在查找house的最近左右取暖器
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
    
        int len = heaters.length;
        for (int house : houses) {
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int dist1 = (right == len) ? Integer.MAX_VALUE : heaters[right]-house;
            int dist2 = (right == 0) ? Integer.MAX_VALUE : house-heaters[right-1];
            res = Math.max(res, Math.min(dist1, dist2));
        }
    
        return res;
    }
}

