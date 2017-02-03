247. Strobogrammatic Number II 

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.



public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), r = two;
        if(n%2 == 1)
            r = one;
        for(int i=(n%2)+2; i<=n; i+=2){
            List<String> newList = new ArrayList<>();
            for(String str : r){
                if(i != n)
                    newList.add("0" + str + "0");
                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;   
    }

}

/////////////////////////////////////////////////////////////

//recursion
public List<String> findStrobogrammatic(int n) {
    findStrobogrammaticHelper(new char[n], 0, n - 1);
    return res;
}

List<String> res = new ArrayList<String>();

public void findStrobogrammaticHelper(char[] a, int l, int r) {
    if (l > r) {
        res.add(new String(a));
        return;
    }
    if (l == r) {
        a[l] = '0'; res.add(new String(a));
        a[l] = '1'; res.add(new String(a));
        a[l] = '8'; res.add(new String(a));
        return;
    }
    
    if (l != 0) {
        a[l] = '0'; a[r] = '0';
        findStrobogrammaticHelper(a, l+1, r-1);
    }
    a[l] = '1'; a[r] = '1';
    findStrobogrammaticHelper(a, l+1, r-1);
    a[l] = '8'; a[r] = '8';
    findStrobogrammaticHelper(a, l+1, r-1);
    a[l] = '6'; a[r] = '9';
    findStrobogrammaticHelper(a, l+1, r-1);
    a[l] = '9'; a[r] = '6';
    findStrobogrammaticHelper(a, l+1, r-1);
}