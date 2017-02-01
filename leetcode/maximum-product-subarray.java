152. Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.


/*
Besides keeping track of the largest product, we also need to keep track of the smallest product. Why? The smallest product, which is the largest in the negative sense could become the maximum when being multiplied by a negative number.

Let us denote that:

f(k) = Largest product subarray, from index 0 up to k.
 

Similarly,

g(k) = Smallest product subarray, from index 0 up to k.
 

Then,

f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
 

There we have a dynamic programming formula. Using two arrays of size n, we could deduce the final answer as f(n-1). Since we only need to access its previous elements at each step, two variables are sufficient.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i< nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(nums[i], nums[i] * temp), nums[i] * min);
            min = Math.min(Math.min(nums[i], nums[i] * temp), nums[i] * min);
            result = Math.max(max, result);
        }
        return result;
    }
}

