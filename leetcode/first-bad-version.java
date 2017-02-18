278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while(left<right) {
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }
}

///////////////////////////////////////

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1, r=n;
        int res=0;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(isBadVersion(mid)) {
                res=mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return res;
    }
}
