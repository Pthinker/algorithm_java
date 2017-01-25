Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> dataIdxMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++) {
            dataIdxMap.put(nums[i], i);
        }
        
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            int n = target-nums[i];
            if(dataIdxMap.containsKey(n) && i!=dataIdxMap.get(n)) {
                res[0] = i;
                res[1] = dataIdxMap.get(n);
                break;
            }
        }
        
        return res;
    }
}


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }
}