40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all 
unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ... , ak) must be in non-descending 
order. (ie, a1 <= a2 <= ... <= ak).
The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]


public class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        Arrays.sort(a);
        solve(a, target, 0, 0, l, res);
        return res;
    }  
    public void solve(int[] a, int target, int sum, int i, List<Integer> l, List<List<Integer>> res) {  
        if(sum == target) { 
            res.add(new ArrayList(l));
            return;
        }

        if(sum>target) 
            return;  
         
        for(int j=i; j<a.length; j++) {
            if(j>i && a[j]==a[j-1]) {
                continue;
            }
            l.add(a[j]);
            solve(a, target, sum+a[j], j+1, l, res);
            l.remove(l.size()-1);
        }  
        return;
    }
}
