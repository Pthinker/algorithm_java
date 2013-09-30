Given a number represented as an array of digits, plus one to the number.


public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0)
            return digits;

        int advance = 1;

        for(int i=(digits.length-1); i>=0; i--) {
        	int sum = digits[i] + advance;

        	if(sum>9) {
        		advance = 1;
        		digits[i] = 0;
        	} else {
        		advance = 0;
        		digits[i] = sum;
        	}
        }

        if(advance==1) {
        	int[] newDigits = new int[digits.length+1];
        	newDigits[0] = 1;
        	for(int i=1; i<newDigits.length; i++)
        		newDigits[i] = digits[i-1];
        	return newDigits;
        }

        return digits;
    }
}
