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


public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        subsets(res, S, 0, tmp);
        
        return res;
    }
    
    public void subsets(ArrayList<ArrayList<Integer>> res, int[] S, 
                        int start, ArrayList<Integer> tmp) {
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

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S==null) 
        	return null;

        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = 
        	new ArrayList<ArrayList<Integer>>();
                                     
        for(int i=0; i<S.length; i++) {
            ArrayList<ArrayList<Integer>> cur = 
            	new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> temp : res) {
                cur.add(new ArrayList<Integer>(temp));
            }
            
            for(ArrayList<Integer> temp : cur) {
                temp.add(S[i]);
            }
            
            ArrayList<Integer> temp1 = new ArrayList<Integer>();
            temp1.add(S[i]);
            cur.add(temp1);
            
            res.addAll(cur);
        }
        res.add(new ArrayList<Integer>());
        
        return res;
    }
}

///////////////////////////////////////////////////////////////////////////

public class Solution {  
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        ArrayList<ArrayList<Integer>> results = 
            new ArrayList<ArrayList<Integer>>();  
        boolean[] visit = new boolean[S.length];  
        work(S, visit, 0, results);  
        return results;  
    }  
      
    public void work(int[] S, boolean[] visit, int index, 
                     ArrayList<ArrayList<Integer>> results) {  
        if (index >= S.length) {  
            ArrayList<Integer> item = new ArrayList<Integer>();  
            for (int i=0; i<S.length; i++)  
                if (visit[i])  
                    item.add(S[i]);  
            Collections.sort(item);  
            results.add(item);  
            return;  
        }

        visit[index] = false;  
        work(S, visit, index+1, results);
          
        visit[index] = true;  
        work(S, visit, index+1, results);  
    }
}
