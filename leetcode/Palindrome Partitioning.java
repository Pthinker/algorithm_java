Given a string s, partition s such that every substring of the partition is 
a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
    ["aa","b"],
    ["a","a","b"]
]


public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        if(s==null || s.length()==0)
            return res;
        
        ArrayList<String> tmp = new ArrayList<String>();
        solve(s, res, 0, tmp);
        return res;
    }
    
    public void solve(String s, ArrayList<ArrayList<String>> res, int start, 
                    ArrayList<String> tmp) {
        if(start>=s.length()) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        
        for(int i=start+1; i<=s.length(); i++) {
            if(isPalindrome(s.substring(start, i))) {
                tmp.add(s.substring(start, i));
                solve(s, res, i, tmp);
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

/////////////////////////////////////////////////////////////////////////////////

public class Solution {
    ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
    
    boolean isPalin(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) 
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    void dfs(String s, int start, ArrayList<String> al) {
        if(start==s.length()) {
            all.add(new ArrayList<String>(al));
            return;
        }
        for(int i=start+1; i<=s.length(); i++) {
            if(isPalin(s, start, i-1)) {
                al.add(s.substring(start, i));
                dfs(s, i, al);
                al.remove(al.size()-1);
            }
        }    
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
        all.clear();
        ArrayList<String> al = new ArrayList<String>();
        dfs(s, 0, al);
        return all;
    }
}
