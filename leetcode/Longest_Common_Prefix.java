14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array 
of strings.


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";

       	int index = 0;

       	while(index < strs[0].length()) {
            for(int i=1; i<strs.length; ++i) {
       			    if((index>=strs[i].length()) || 
                       (strs[i].charAt(index)!=strs[0].charAt(index)))
       				     return strs[0].substring(0, index);
       		  }
       		  index++;
       	}

       	return strs[0];
    }
}


/////////////////////////////////////////////////////////////

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0) {
            return "";
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strs[0].length(); i++) {
            boolean stop = false;
            char c = strs[0].charAt(i);
            for(int n=1; n<strs.length; n++) {
                if(i>=strs[n].length() || strs[n].charAt(i)!=c) {
                    stop = true;
                    break;
                }
            }
            if(stop) {
                break;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
