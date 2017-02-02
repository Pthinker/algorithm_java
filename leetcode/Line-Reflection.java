356. Line Reflection

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.


public boolean isReflected(int[][] points) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    Set<String> set = new HashSet<String>();
    for (int[] p : points) {
        set.add(p[0] + "," + p[1]);
        min = Math.min(min, p[0]);
        max = Math.max(max, p[0]);
    }
    
    int sum = min + max;
    for (int[] p : points) {
        if (!set.contains((sum - p[0]) + "," + p[1])) {
            return false;
        }
    }
    return true;
}
    