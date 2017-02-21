50. Pow(x, n)

Implement pow(x, n).


public class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        if(n<0) {
            return 1/myPow(x, -n);
        }
        
        if(n%2==0) {
            double res = myPow(x, n/2);
            return res * res;
        } else {
            return x * myPow(x, n-1);
        }
    }
}



public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 0) return 0.0;
        if(n < 0){
            x = 1.0 / x;
        }else{
            n = -n;
        }
        double rst = 1.0;
        while(n < 0){
            if(n % 2 != 0){
                rst *= x;
            }
            x = x * x;
            n = n / 2;
        }
        return rst;
    }
}