/* In a string, find the first character that only appear once in the string
 * http://blog.csdn.net/v_july_v/article/details/6347454
 */

import java.io.*;
import java.util.*;

public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "abaccdeff";

        solve(s);
    }
    
    public static void solve(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            if(ht.containsKey(s.charAt(i))) {
                ht.put(s.charAt(i), ht.get(s.charAt(i))+1);
            } else {
                ht.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i<s.length(); i++) {
            if(ht.get(s.charAt(i))==1) {
                System.out.println(s.charAt(i));
                return;
            }
        }
        
        System.out.println("Cannot find!");
    }
}
