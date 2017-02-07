47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)
            return res;
        
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] selected = new boolean[nums.length];
        permute(nums, res, tmp, selected);
        return res;
    }
    
    public void permute(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] selected) {
        if(tmp.size()==nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(i>0 && !selected[i-1] && nums[i]==nums[i-1]) {
                continue;
            }
            if(!selected[i]) {
                selected[i] = true;
                tmp.add(nums[i]);
                permute(nums, res, tmp, selected);
                selected[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
