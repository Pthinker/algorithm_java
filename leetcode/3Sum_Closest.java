Given an array S of n integers, find three integers in S such that the sum 
is closest to a given number, target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int min = num[0] + num[1] + num[2] - target;

        for(int i=0; i<num.length-2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while(left < right) {
                int r = num[i] + num[left] + num[right] - target;
                if(r == 0) 
                    return target;

                if(Math.abs(r) < Math.abs(min)) 
                    min = r;               

                if(r > 0)
                    right--;
                else
                    left++;
            }
        }

        return min + target;
    }
}
