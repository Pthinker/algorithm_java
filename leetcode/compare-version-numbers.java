165. Compare Version Numbers

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        // 比对相应的子串
        for(; i < v1.length && i < v2.length; i++){
            int val1 = Integer.parseInt(v1[i]);
            int val2 = Integer.parseInt(v2[i]);
            if(val1 < val2) return -1;
            if(val1 > val2) return 1;
        }
        // 如果某个版本号更长，判断其多余部分是否是0，如果不是0，则较长的较大，否则是一样的。
        if(v2.length > v1.length){
            for(; i < v2.length; i++){
                int val = Integer.parseInt(v2[i]);
                if(val != 0) return -1;
            }
        } else if(v1.length > v2.length){
            for(; i < v1.length; i++){
                int val = Integer.parseInt(v1[i]);
                if(val != 0) return 1;
            }
        }
        return 0;
    }
}