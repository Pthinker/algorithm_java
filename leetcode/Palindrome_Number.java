Determine whether an integer is a palindrome. Do this without extra space.


public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int num = 1;
 		int n = x;
 		while((n=n/10)!=0) {
 			num *= 10;
 		}    

 		while(x >= 10) {
 			int r = x - x / 10 * 10;
 			int l = x / num;

 			if(r!=l)
 				return false;

 			x = (x - l * num) / 10;

 			num /= 100;
 		}
         
        return true;
    }
}