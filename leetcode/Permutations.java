Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0)
            return res;
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        boolean[] selected = new boolean[num.length];
        permute(num, res, tmp, selected);
        return res;
    }
    
    public void permute(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, boolean[] selected) {
        if(tmp.size()==num.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<num.length; i++) {
            if(!selected[i]) {
                selected[i] = true;
                tmp.add(num[i]);
                permute(num, res, tmp, selected);
                selected[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}

//////////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int i=0; i<num.length; i++) {
            ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> temp : res) {
                for(int j=0; j<temp.size()+1; j++) {
                    temp.add(j, num[i]);
                    ArrayList<Integer> temp1 = new ArrayList<Integer>(temp);
                    cur.add(temp1);
                    temp.remove(j);
                }
            }
            res = new ArrayList<ArrayList<Integer>>(cur);
        }
        return res;
    }
}

