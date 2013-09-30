Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


// recurvise method, time limit exceeded for large dataset
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length() + s2.length() != s3.length())
        	return false;

        if(s1.length()==0 || s2.length()==0 || s3.length()==0) {
        	if((s1 + s2).equals(s3))
        		return true;
        	else
        		return false;
        }

        if(s1.charAt(0)!=s3.charAt(0) && s2.charAt(0)!=s3.charAt(0))
        	return false;

        if( s1.charAt(0)==s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1)))
        	return true;

        if( s2.charAt(0)==s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)))
        	return true;

        return false;
    }
}

//////////////////////////////////////////////////////////////////

// dynamic programming
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s3.length() != (s1.length() + s2.length())) 
    		return false;

    	boolean [][] match = new boolean [s1.length()+1][s2.length()+1];
    	match[0][0]=true;

    	int i = 1;
        while(i<=s1.length() && s1.charAt(i-1)==s3.charAt(i-1)) {
            match[i][0]=true;
            i++;
        }
       
        i = 1;
        while(i<=s2.length() && s2.charAt(i-1)==s3.charAt(i-1)) {
            match[0][i]=true;
            i++;
        }

        for(i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
            	char c = s3.charAt(i+j-1);
                if(c==s1.charAt(i-1))
                	match[i][j] = match[i-1][j] || match[i][j];
               	if(c==s2.charAt(j-1))
                	match[i][j] = match[i][j-1] || match[i][j];
            }
        }

        return match[s1.length()][s2.length()];
    }
}
