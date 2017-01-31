39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]


This is a mutation of subset sum problem. It has pseudo polynomial solution, 
which can be done in DP.

The problem can also be asked like: give sum n, and m different valued coins, 
how many ways can you make changes from these coins, order does not matter.


The easier version is to just output how many ways. just a few lines. 
the idea is the knapsack solution. time complexity O(n*target),space 
complexity O(target).

public void combinationSum(int[] candidates, int target) {   
	int dp[] = new int[target + 1];  
	dp[0] = 1;
	  
	for(int i=0; i<candidates.length; i++)  
		for(int s=0; s<target+1; s++) {
	    	if(s>=candidates[i]) 
	    		dp[s] = dp[s-candidates[i]] + dp[s];  
	}  
	System.out.println(dp[target]);
	return;
}

The harder version is to output the subset candidates. still the same idea, 
just a few modifications. time complexity stays but space complexity increases.

import java.util.*;  
public class Solution {  
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, 
    													int target) {  
        Hashtable h = new Hashtable<Integer, ArrayList<ArrayList<Integer>>>();  
          
        Arrays.sort(candidates);  
        ArrayList<Integer> m = new ArrayList<Integer>();  
        ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();  
        
        n.add(m);  
        h.put(0, n);

        ArrayList<ArrayList<Integer>> a, b, c;  
        
        for(int i=0; i<candidates.length; i++)  
        	for(int s=1; s<target+1; s++) {  
            	if(s>=candidates[i] && h.containsKey(s-candidates[i])) {
                	a = new ArrayList<ArrayList<Integer>>();
                	c = ((ArrayList<ArrayList<Integer>>)(h.get(s - candidates[i])));  
                	for(ArrayList<Integer> x : c) {
                        ArrayList<Integer> y = new ArrayList<Integer>(x);   
                        y.add(candidates[i]);
                        a.add(y);
                    }
            		if(h.containsKey(s)) { 
            			b = ((ArrayList<ArrayList<Integer>>)(h.get(s))); 
            			b.addAll(a);
            		}
            		else 
            			h.put(s, a);
            	} 
            }   
    	
    	return (ArrayList<ArrayList<Integer>>)h.get(target)==null ? 
    		new ArrayList<ArrayList<Integer>>():
    		(ArrayList<ArrayList<Integer>>)h.get(target); 
	}
}


surely the harder version can be done by DFS or backtracking, which is easier for printing the result.
Below is backtracking.

public class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
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
            l.add(a[j]);
            solve(a, target, sum+a[j], j, l, res);
            l.remove(l.size()-1);
        }  
        return;
    }
}
