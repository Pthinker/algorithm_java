342. Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?


public class Solution {
    public boolean isPowerOfFour(int num) {
        while (num>0 && (num % 4 == 0)) {
            num /= 4;
        }
        return num == 1;
    }
}

///////////////////////////////////////////////////////////
//bit  100, 10000, 1000000
public class Solution {
    public boolean isPowerOfFour(int num) {
        int count0=0;
        int count1=0;
     
        while(num>0){
            if((num&1)==1){
                count1++;
            }else{
                count0++;
            }
     
            num>>=1;
        }
     
        return count1==1 && (count0%2==0);
    }
}