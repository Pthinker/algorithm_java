78. Subsets

Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


// recursive: for each element, whether add or not add
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        subsets(res, S, 0, tmp);
        
        return res;
    }
    
    public void subsets(List<List<Integer>> res, int[] S, int start, List<Integer> tmp) {
        if(start>=S.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        subsets(res, S, start+1, tmp);
        
        tmp.add(S[start]);
        subsets(res, S, start+1, tmp);
        tmp.remove(tmp.size()-1);
    }
}

///////////////////////////////////////////////////////////////////////////

// Iterative:我们可以一位一位的网上叠加，比如对于题目中给的例子[1,2,3]来说，最开始是空集，那么我们现在要处理1，就在空集上加1，为[1]，现在我们有两个自己[]和[1]，下面我们来处理2，我们在之前的子集基础上，每个都加个2，可以分别得到[2]，[1, 2]，那么现在所有的子集合为[], [1], [2], [1, 2]，同理处理3的情况可得[3], [1, 3], [2, 3], [1, 2, 3], 再加上之前的子集就是所有的子集合了
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if(S==null) 
        	return null;

        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
                                     
        for(int i=0; i<S.length; i++) {
            List<List<Integer>> cur = new ArrayList<List<Integer>>();
            for(List<Integer> temp : res) {
                cur.add(new ArrayList<Integer>(temp));
            }
            
            for(List<Integer> temp : cur) {
                temp.add(S[i]);
            }
            
            List<Integer> temp1 = new ArrayList<Integer>();
            temp1.add(S[i]);
            cur.add(temp1);
            
            res.addAll(cur);
        }
        res.add(new ArrayList<Integer>());
        
        return res;
    }
}
