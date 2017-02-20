22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


//mine
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n<=0) return res;
        
        generate("", 0, 0, n, res);
        return res;
    }
    
    private void generate(String cur, int l, int r, int n, List<String> res) {
        if(l==n && r==n) {
            res.add(cur);
            return;
        }
        
        if(l<n) {
            generate(cur+"(", l+1, r, n, res);
        }
        if(r<l) {
            generate(cur+")", l, r+1, n, res);
        }
    }
}
