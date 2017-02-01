18. 4sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum > target)
                        high--;
                    else if(sum < target)
                        low++;
                    else {
                        List<Integer> quadruplet = new ArrayList<Integer>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[low]);
                        quadruplet.add(nums[high]);
                        if(!sol.contains(quadruplet))
                            sol.add(quadruplet);
                        low++;
                        high--;
                    }
                }
            }
        }
        return sol;
    }
}
