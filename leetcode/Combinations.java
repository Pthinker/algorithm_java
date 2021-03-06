77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> al = new ArrayList<Integer>();
        combine(n, 1, k, res, al);
        
        return res;
    }
    
    public void combine(int n, int start, int k, List<List<Integer>> res, List<Integer> al) {
        if(al.size()==k) {
            res.add(new ArrayList<Integer>(al));
            return;
        }
        
        for(int i=start; i<=n; i++) {
            al.add(i);
            combine(n, i+1, k, res, al);
            al.remove(al.size()-1);
        }
    }
}

