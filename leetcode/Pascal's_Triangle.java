118. Pascal Triangle

Given numRows, generate the first numRows of Pascal''s triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        
        for(int i=1; i<=numRows; i++) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if(i==1) {
                result.add(1);
                results.add(result);
            } else {
                result.add(1);
                List<Integer> prev = results.get(results.size()-1);
                for(int j=1; j<prev.size();j++) {
                    result.add(prev.get(j) + prev.get(j-1));
                }
                result.add(1);
                results.add(result);
            }
        }
        return results;
    }
}