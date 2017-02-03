413. Arithmetic Slices

A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.


//http://www.cnblogs.com/grandyang/p/5968340.html
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res=0, len=2, n=nums.length;
        for (int i=2; i<n; ++i) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                ++len;
            } else {
                if (len > 2) {
                    res += (len-1) * (len - 2) * 0.5;
                len = 2;
                }
            }
        }
        if (len > 2) {
            res += (len - 1) * (len - 2) * 0.5;
        }
        return res;
    }
}

////////////////////////////////////////
//DP
