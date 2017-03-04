93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        
        if(s==null || s.length()<4 || s.length()>12)
            return res;
        
        ArrayList<String> tmp = new ArrayList<String>();
        find(res, s, 0, tmp);
        return res;
    }
    
    public void find(ArrayList<String> res, String s, int index, ArrayList<String> tmp) {
        if(index>=s.length()) {
            if(tmp.size()==4) {
                String r = "";
                for(int i=0; i<3; i++)
                    r += tmp.get(i) + ".";
                r += tmp.get(3);
                res.add(r);
            }
            return;
        }
        
        if(s.charAt(index)=='0') {
            tmp.add("0");
            find(res, s, index+1, tmp);
            tmp.remove(tmp.size()-1);
        } else {
            for(int i=1; i<=3 && index+i<=s.length(); i++) {
                if(Integer.parseInt(s.substring(index, index+i)) <= 255) {
                    tmp.add(s.substring(index, index+i));
                    find(res, s, index+i, tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}

///////////////////////////////////////////////////////////////////////////

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length()>12 || s.length()<4) 
        	return res;
        dfs(res, "", s, 0);
        return res;
    }

    public void dfs(List<String> res, String buff, String s, int count) {
        if(count == 3 && isValid(s)) {
            res.add(buff+s);
            return;
        }

        for(int i=1; i<4 && i<s.length(); i++) {
            String substr = s.substring(0, i);
            if(isValid(substr))
                dfs(res, buff+substr+".", s.substring(i), count+1);
        }
    }

    public boolean isValid(String s) {
        if(s.charAt(0)=='0')
        	return s.equals("0");
        int num = Integer.parseInt(s);
        return num>=0 && num<=255;
    }
}
