491. Increasing Subsequences

Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.


public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) {
            return res;
        }
        
        List<Integer> row = new ArrayList<Integer>();
        dfs(nums, res, 0, row, Integer.MIN_VALUE);
        
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, int start, List<Integer> row, int prev) {
        if(start >= nums.length) {
            return;
        }

        Set<Integer> used = new HashSet<>();
        for(int i=start; i<nums.length; i++) {
        	if(used.contains(nums[i])) continue;

            if(nums[i]>=prev) {
                row.add(nums[i]);
                used.add(nums[i]);
                if(row.size()>1) {
                    res.add(new ArrayList<Integer>(row));
                }
                dfs(nums, res, i+1, row, nums[i]);
                row.remove(row.size()-1);
            }
        }
    }
}


////////////////////

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res; 
    }
    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1) {
            res.add(new LinkedList<Integer>(list));
        }
        
        Set<Integer> used = new HashSet<>();
        for(int i=index; i<nums.length; i++){
            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]); 
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }
}