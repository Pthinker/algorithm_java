320 Generalized Abbreviation

Write a function to generate the generalized abbreviations of a word.

Example:

Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]


public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        helper(word, 0, "", res, false);
        return res;
    }
    // isAbbrPrev: false, we can add alphabet or abbreviation(number) next round
    // isAbbrPrev: true,  we can add alphabet ONLY next round
    public void helper(String word, int start, String cur, List<String> res, boolean isAbbrPrev) {
        if (start == word.length()) {
            res.add(cur);
            return;
        }
        if (isAbbrPrev == false) { // we can add abbreviation (num)
            for(int end=start+1; end<=word.length(); end++) { // iterate all abbreviations from 'start'
                helper(word, end, cur + Integer.toString(end-start), res, true);
            }
        }
        helper(word, start+1, cur + word.charAt(start), res, false); // adding one word each time
    }
}

