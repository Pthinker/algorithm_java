public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int cnt=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                if (cnt>max) {
                    max=cnt;
                }
                cnt=0;
            } else {
                cnt+=1;
            }
        }
        if(max>cnt) {
            return max;
        } else {
            return cnt;
        }
    }
}