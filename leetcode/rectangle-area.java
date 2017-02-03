223. Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Assume that the total area is never beyond the maximum possible value of int.


public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (H - F) * (G - E);
        if (E >= C || F >= D || B >= H || A >= G) return sum;
        return sum - ((Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F)));
    }
}

///////////////////////////////////

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);
        
        return areaOfSqrA + areaOfSqrB - overlap;
    }
}