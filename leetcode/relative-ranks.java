506. Relative Ranks

Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won''t exceed 10,000.
All the scores of athletes are guaranteed to be unique.


public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if(nums == null || nums.length == 0) return new String[0];
        int n = nums.length;
        String[] result = new String[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n; ++i){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for( int i = 0; i < n/2; ++i ) { 
            int temp = nums[i]; 
            nums[i] = nums[n - i - 1]; 
            nums[n - i - 1] = temp; 
        }
        
        result[map.get(nums[0])] = "Gold Medal";
        if(1 < n) result[map.get(nums[1])] = "Silver Medal";
        if(2 < n) result[map.get(nums[2])] = "Bronze Medal";
        for(int j = 3; j < n; ++j){
            result[map.get(nums[j])] = String.valueOf(j + 1);
        }
        return result;
    }
}