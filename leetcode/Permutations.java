46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0) {
            return res;
        }
        
        List<Integer> rec = new ArrayList<Integer>();
        boolean[] flag = new boolean[nums.length];
        
        helper(res, rec, nums, flag);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> rec, int[] nums, boolean[] flag) {
        if(rec.size() == nums.length) {
            res.add(new ArrayList<Integer>(rec));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!flag[i]) {
                rec.add(nums[i]);
                flag[i] = true;
                helper(res, rec, nums, flag);
                flag[i] = false;
                rec.remove(rec.size()-1);
            }
        }
    }
}
