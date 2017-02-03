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


public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, 0, sb, result);
        return result;
    }

    public void generateParenthesis(int n, int s, int e, int l, 
                                    StringBuilder sb, ArrayList<String> result) {
    	if (s == n && e == n) {
    		result.add(sb.toString());
    	} else {
    		if (l > 0 && e < n) {
    			sb.append(')');
    			generateParenthesis(n, s, e + 1, l - 1, sb, result);
    			sb.deleteCharAt(sb.length() - 1);
    		}

    		if (s < n) {
    			sb.append('(');
    			generateParenthesis(n, s + 1, e, l + 1, sb, result);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    	}
    }
}

/////////////////////////////////////////////////////////////////////////////

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateParenthesis("", 0, 0, n, list);
        return list;
    }
     
    private void generateParenthesis(String s, int left, int right, int n, 
                                     List<String> list){
        if(left==n && right==n) {
            list.add(s);
            return;
        }
        if(left < n)
            generateParenthesis(s+"(", left+1, right, n, list);
        if(right < left)
            generateParenthesis(s+")", left, right+1, n, list);
    }
}

/////////////////////////////////////////////////////////////////////////////

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(result, "", 0, 0, n);
        return result;
    }
    
    private void generate(List<String> result, String prefix, int leftCount, int rightCount, int totalPairs) {
        if(leftCount == totalPairs) {
            for(int i = 0; i < totalPairs - rightCount; i++) {
                prefix += ")";
            }
            result.add(prefix);
            return;
        }
        generate(result, prefix + "(", leftCount+1, rightCount, totalPairs);
        if(leftCount > rightCount) 
            generate(result, prefix +")", leftCount, rightCount+1,totalPairs);
    }
}
