

Implement pow(x, n).


//https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) return half * half;
        else if (n > 0) return half * half * x;
        else return half * half / x;
    }
}


