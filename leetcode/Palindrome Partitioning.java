131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]


public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        if(s==null || s.length()==0)
            return res;
        
        List<String> tmp = new ArrayList<String>();
        dfs(s, res, 0, tmp);
        return res;
    }
    
    public void dfs(String s, List<List<String>> res, int start, List<String> tmp) {
        if(start>=s.length()) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        
        for(int i=start+1; i<=s.length(); i++) {
            if(isPalindrome(s.substring(start, i))) {
                tmp.add(s.substring(start, i));
                dfs(s, res, i, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}