Implement int sqrt(int x).

Compute and return the square root of x.


public class Solution {
    public int sqrt(int x) {
        long lo = 0; long hi = x;
 
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) >= x)
                if ((mid + 1) * (mid + 1) == x)
                    return (int) mid + 1;
                else
                    return (int) mid;
            else if (mid * mid < x)
                lo = mid;
            else 
                hi = mid;
        }      
 
        return 0;
    }
}

///////////////////////////////////////////////////////////////

public class Solution {
    public int sqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        
        double y = ((double)x)/2.;
        while(Math.abs(y*y-x)>0.00001){
            y=(y+x/y)/2.;
        }
        return (int) y;
    }
}
