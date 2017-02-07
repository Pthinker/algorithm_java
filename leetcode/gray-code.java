89. Gray Code

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        helper(result,list,n);
        return result;
    }
    
    public void helper(List<Integer> result,List<Integer> list,int n) {
        if(list.size() == Math.pow(2,n)){
            result.addAll(list);
            return;
        }
        int last = list.get(list.size() - 1);
        
        for(int i = 0; i < n; i++) {
            int off = 1 << i;
            int cur = last ^ off;
            
            if(list.contains(cur)) continue;
            
            list.add(cur);
            helper(result,list,n);
            
            if(result.size() > 0) return;
            list.remove(list.size() - 1);
        }
    }
}
