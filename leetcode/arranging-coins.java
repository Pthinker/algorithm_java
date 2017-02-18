441. Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.


//n = (1 + x) * x / 2
public class Solution {
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}

////////////////////////////////////////////

//binary search
public class Solution {
    public int arrangeCoins(int n) {
        //convert int to long to prevent integer overflow
        long nLong = (long)n;
        
        long st = 1;
        long ed = nLong;
        
        long mid = 0;
        
        while (st <= ed){
            mid = st + (ed - st) / 2;
            long total = mid * (mid + 1);
            if(total==2*nLong) {
                return (int)mid;
            }else if ( total < 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }
        
        return (int)ed;
    }
}
