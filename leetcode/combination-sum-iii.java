216. Combination Sum III

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]


public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        solve(k, n, 1, l, res);
        return res;
    }  
    public void solve(int k, int n, int level, List<Integer> l, List<List<Integer>> res) {  
        if(n<0) return;
        if(n==0 && l.size()==k) { 
            res.add(new ArrayList(l));
            return;
        }

        for(int i=level; i<=9; i++) {
            l.add(i);
            solve(k, n-i, i+1, l, res);
            l.remove(l.size()-1);
        }  
        return;
    }
}
