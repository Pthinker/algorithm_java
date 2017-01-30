90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (nums == null || nums.length== 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> cur, int i) {
        for (int j=i; j<nums.length; j++) {
        	if (j>i && nums[j]==nums[j-1]) {
                continue;
            }
            cur.add(nums[j]);
            result.add(new ArrayList<Integer>(cur));
            helper(result, nums, cur, j + 1);
            cur.remove(cur.size()-1);
        }
    }
}