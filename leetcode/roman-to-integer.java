13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.


public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length()==0) {
            return 0;
	    }
	    
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int res = 0;
	    int i=0; 
	    while(i<length) {
	        int p = m.get(s.charAt(i));
	        if(i<length-1) {
	            int n = m.get(s.charAt(i+1));
	            if(n<=p) {
	                res += p;
	            } else {
	                res += n-p;
	                i++;
	            }
	        } else {
	            res += p;
	        }
	        i++;
	    }
	    
	    return res;
    }
}

//////////////////////////////////////////

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length()==0) {
                return 0;
	    }
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int result = m.get(s.charAt(length - 1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
    }
}
