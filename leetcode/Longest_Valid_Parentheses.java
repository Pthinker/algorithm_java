Given a string containing just the characters '(' and ')', find the length of 
the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring 
is "()()", which has length = 4.


public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2)
            return 0;
            
        Stack<Integer> st = new Stack<Integer>();
        int last = -1;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') { 
                st.push(i);
            } else if(s.charAt(i)==')') {
                if(st.empty()) { //no matching (, then update last
                    last = i;
                } else {
                    st.pop(); //matching (, pop it out
                    if(st.empty())
                        max = Math.max(max, i-last);
                    else
                        max = Math.max(max, i-st.peek());
                }
            }
        }
        return max;
    }
}

/////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> sk = new Stack<Integer>();
        int longest = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c=='(') {
                sk.push(i);
            } else if(c==')') {
                if(!sk.empty() && s.charAt(sk.peek())=='(') {
                    sk.pop();
                    int len = sk.empty() ? i+1 : i-sk.peek();
                    longest = Math.max(len, longest);
                } else {
                    sk.push(i);
                }
            }
        }
        return longest;
    }
}

/////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> store = new Stack<Integer>();
        int[] right = new int[c.length];
        
        int res = 0;
        for(int i=0; i<c.length; i++) {
            if(c[i]=='(') {
                store.push(i);
            } else {
                if(!store.isEmpty()) {
                    right[i] = store.pop() + 1;
                    int temp = right[i] - 2;
                    if(temp>=0 && right[temp]>0) {
                        right[i] = right[temp];
                    } 
                    res = Math.max(i-right[i]+2, res);
                }
            }
        }
        return res;
    }
}
