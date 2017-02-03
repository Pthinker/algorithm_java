91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using 
the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of 
ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.


public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        
        if(s.length()==1)
            return 1;
        
        int[] res = new int[s.length()];
        res[0] = 1;
        res[1] = check(s.charAt(1)) + check(s.charAt(0), s.charAt(1));
        
        for(int i=2; i<s.length(); i++) {
            if(check(s.charAt(i))==1)
                res[i] = res[i-1];
            
            if(check(s.charAt(i-1), s.charAt(i))==1)
                res[i] += res[i-2];
            
            if(res[i]==0)
                return 0;
        }
        
        return res[s.length()-1];
    }
    
    public int check(char a) {
        return a=='0' ? 0 : 1;
    }
    
    public int check(char a, char b) {
        return (a=='1' || (a=='2' && b<='6')) ? 1:0;
    }
}

////////////////////////////////////////////////////////////////////////

// DP. Similar as "[LeetCode] Climbing Stairs, Solution". Just add some logic 
// to compare character.
// Transformation function as:
// Count[i] = Count[i-1]  if S[i-1] is a valid char
//     or   = Count[i-1]+ Count[i-2]  if S[i-1] and S[i-2] together is 
//            still a valid char.

public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        if(s.length()==1)
            return check(s.charAt(0));
        
        int fn = 0;
        int fn_1 = check(s.charAt(0))*check(s.charAt(1)) + 
               check(s.charAt(0), s.charAt(1));
        int fn_2 = check(s.charAt(0));
        
        for(int i=2; i<s.length(); i++) {
            if(check(s.charAt(i))==1)
                fn += fn_1;
            
            if(check(s.charAt(i-1), s.charAt(i))==1)
                fn += fn_2;
            
            if(fn==0)
                return 0;
            
            fn_2 = fn_1;
            fn_1 = fn;
            fn = 0;
        }
        return fn_1;
    }
    
    public int check(char a) {
        return a=='0' ? 0:1;
    }
    
    public int check(char a, char b) {
        return (a=='1' || (a=='2' && b<='6')) ? 1:0;
    }
}

////////////////////////////////////////////////////////////////////////

/*
In this problem, you should consider many cases, and some of them are tricky. 

1. If there is one digit, then it's obvious. If the digit is not equal to 0, 
we have only one way to decode. If the digit is 0, we have no ways to decode.
2. If the number has two digits. You should consider
10: 1 way, 
11-19 : 2 ways,
20: 1 way,
21-26: 2 ways,
27-29: 1 way
30,40,50,...,90: 0 way
31-39, 41-49,...,91-99: 1 way

3. If the number has len>=3 digits or more, the number is
1) the first digit starts with 0,
   decodeWays=0;
2) the first two digits are from 11 to 19 or 21 to 26
decodeWays(x)=decodeWays(1 digit after x) + decodeWays(2 digits after x)
3) the first two digits are others
decodeWays(x)=decodeWays(1 digit after x)

After considering these trivial cases, you can start coding. But, keep in mind 
that the recursion call is very expensive. I tried the first time using 
recursion, then the time limit exceeded.

Then I use DP to store the intermediate decodeWays. Keeping these values, 
recursion is avoided.
*/

public class Solution {
  public int numDecodings(String s) {
      if(s.length()<1)
          return 0;
  
      char[] str = s.toCharArray();
      int[] decodeWays = new int[str.length];
      int last = str.length - 1;

      if(str[last]-'0'==0)
          decodeWays[last] = 0;
      else
          decodeWays[last] = 1;
   
      if(last>=1) {
          if(str[last-1]-'0'>2) {
              if(str[last]-'0'==0)
                  decodeWays[last-1]=0;
              else
                  decodeWays[last-1]=1;
          } else if(str[last-1]-'0'==2) {
              if(str[last]-'0'>6)
                  decodeWays[last-1]=1;
              else if(str[last]-'0'==0)
                  decodeWays[last-1]=1;
              else
                  decodeWays[last-1]=2;
          } else if(str[last-1]-'0'==1) {
              if(str[last]-'0'==0)
                  decodeWays[last-1]=1;
              else
                  decodeWays[last-1]=2;
          } else {
              decodeWays[last-1]=0;
          }
      }
  
      if(last>=2) {
          for(int i=last-2;i>=0;i--) {
              if(str[i]-'0'==0)
                  decodeWays[i]=0;
              else {
                  int ways=0;
                  if(str[i]-'0'<2||(str[i]-'0'==2 && str[i+1]-'0'<=6))
                      ways=1;
                  decodeWays[i]=decodeWays[i+1]+ways*decodeWays[i+2];
              }
          }
      }
  
      return decodeWays[0];
  }
}

////////////////////////////////////////////////////////////////////////

public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) 
            return 0;

        int[] hist = new int[2];
        hist[0] = 1;
        hist[1] = 1;
        
        for(int i=0; i<s.length(); i++) {
            int temp = 0;
            if(s.charAt(i)!='0')
                temp += hist[1];

            if(i>0) {
                int a = Integer.parseInt(s.substring(i-1, i+1));
                if(s.charAt(i-1)!='0' && a<=26 && a>=1)
                    temp += hist[0];
            }
            hist[0] = hist[1];
            hist[1] = temp;
        }
        
        return hist[1];
    }
}
