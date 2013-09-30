Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a 
challenge, please do not see below and ask yourself what are the 
possible input cases.

Notes: It is intended for this problem to be specified 
vaguely (ie, no given input specs). You are responsible to gather 
all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary 
until the first non-whitespace character is found. Then, starting from this 
character, takes an optional initial plus or minus sign followed by as many 
numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the 
integral number, which are ignored and have no effect on the behavior of 
this function.

If the first sequence of non-whitespace characters in str is not a valid 
integral number, or if no such sequence exists because either str is empty 
or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the 
correct value is out of the range of representable values, 
INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.



public class Solution {
    public int atoi(String str) {
        if(str.length()==0)
            return 0;

        boolean neg = false;
        int result = 0;

        int index = 0;
        while(index<str.length() && str.charAt(index)==' ')
        	index++;

        if(index<str.length()) {
        	if(str.charAt(index)=='+') {
        		index++;
        	} else if(str.charAt(index)=='-') {
        		neg = true;
        		index++;
        	} else if(str.charAt(index) < '0' || str.charAt(index) > '9') {
        		return 0;
        	}
        } else {
        	return 0;
        }

        int count = 0;
        while(index < str.length() && str.charAt(index) >= '0' 
                                   && str.charAt(index) <= '9') {
        	if(neg) {
        		if (count == 10 || (count == 9 && result == -214748364 
                                               && str.charAt(index) >= '8')) 
                    return Integer.MIN_VALUE;
        		result = result * 10 - (str.charAt(index) - '0');
        	} else {
        		if (count == 10 || (count == 9 && result == 214748364 
                                               && str.charAt(index) >= '7')) 
                    return Integer.MAX_VALUE;
        		result = result * 10 + (str.charAt(index) - '0');
        	}
        	index++;
        	count++;
        }

        return result;
    }
}
