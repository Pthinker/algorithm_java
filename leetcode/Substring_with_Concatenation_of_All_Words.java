You are given a string, S, and a list of words, L, that are all of the same length. 
Find all starting indices of substring(s) in S that is a concatenation of each 
word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).


public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        if(L==null || L.length==0) 
        	return null;

        int n = L.length, m = L[0].length(), l = S.length();

        ArrayList<Integer> res = new ArrayList<Integer>();

        Map<String, Integer> covered = new HashMap<String, Integer>();

        for(int j=0; j<n; j++) {
            if(covered.containsKey(L[j])) {
                covered.put(L[j], covered.get(L[j])+1);
            } else {
                covered.put(L[j], 1);
            }
        }

        int i = 0;
        while(l-i >= n*m) {
            Map<String, Integer> temp = new HashMap<String, Integer>(covered);
            for(int j=0; j<n; j++) {
                String testStr = S.substring(i+j*m, i+(j+1)*m);
                if(temp.containsKey(testStr)) {
                    if(temp.get(testStr)-1==0)
                        temp.remove(testStr);
                    else
                        temp.put(testStr, temp.get(testStr)-1);
                } else
                    break;
            }
            if(temp.size()==0) 
            	res.add(i);
            i++;
        }
        return res;
    }
}
