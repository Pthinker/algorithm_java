Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.


public class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < len; i++) {
    		if (Character.isDigit(s.charAt(i))) {
    			int sum = s.charAt(i) - '0';
    			while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
    				sum = sum * 10 + s.charAt(i + 1) - '0';
    				i++;
    			}
    			result += sum * sign;
    		} else if (s.charAt(i) == '+')
    			sign = 1;
    		else if (s.charAt(i) == '-')
    			sign = -1;
    		else if (s.charAt(i) == '(') {
    			stack.push(result);
    			stack.push(sign);
    			result = 0;
    			sign = 1;
    		} else if (s.charAt(i) == ')') {
    			result = result * stack.pop() + stack.pop();
    		}
    
    	}
    	return result;
    }
}

///////////////////////////////////////

public class Solution {
    public int calculate(String s) {
        int sign = 1; //'+' = 1, '-' = -1
        int mulDiv = -1; //'none' = -1, '*' = 0, '/' = 1
        int res = 0;
        int preV = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (++i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                i--;
                if (mulDiv == 0) {
                    preV *= num;
                    mulDiv = -1; //reset
                } else if (mulDiv == 1) {
                    preV /= num; 
                    mulDiv = -1; //reset
                } else {
                    preV = num;
                }
            }
            else if (s.charAt(i) == '+') {
                res += sign * preV; //previous sign 
                sign = 1; //current sign
            } else if (s.charAt(i) == '-') {
                res += sign * preV;
                sign = -1;
            } else if (s.charAt(i) == '*') {
                mulDiv = 0;
            } else if (s.charAt(i) == '/') {
                mulDiv = 1;
            }
        }
        res += sign * preV;
        return res;
    }
}