17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.



public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits==null || digits.length()==0) return res;
        
        Map<Character, String> table = new HashMap<Character, String>();
        table.put('2', "abc");
        table.put('3', "def");
        table.put('4', "ghi");
        table.put('5', "jkl");
        table.put('6', "mno");
        table.put('7', "pqrs");
        table.put('8', "tuv");
        table.put('9', "wxyz");
        
        dfs(res, table, digits, "", 0);
        return res;
    }

    public void dfs(List<String> res, Map<Character, String> table, String s, String buff, int count) {
        if(count == s.length()) {
            res.add(buff);
            return;
        }

        for(char c: table.get(s.charAt(count)).toCharArray())
            dfs(res, table, s, buff+c, count+1);
    }
}
