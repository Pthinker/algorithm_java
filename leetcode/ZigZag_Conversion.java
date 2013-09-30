The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder result = new StringBuilder();

        if(s==null || s.length()==0) 
            return result.toString();
        
        if(nRows <= 1) return s;

        for(int i=0; i<nRows; ++i) {
        	if(i == 0 || i==nRows-1) {
        		int j = i;
        		while(j < s.length()) {
        			result.append(s.charAt(j));
        			j = j + 2 * nRows - 2;
        		}
        	} else {
        		int j = i;
        		boolean flag = true;
        		while(j < s.length()) {
        			result.append(s.charAt(j));
        			if(flag) {
        				j = j + 2 * nRows - 2 - 2 * i;
        			} else {
        				j = j + 2 * i;
        			}
        			flag = !flag;
        		}
        	}
        }
        return result.toString();
    }
}

