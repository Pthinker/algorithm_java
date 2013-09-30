/* http://www.mitbbs.com/article_t1/JobHunting/32364859_0_1.html
 *
 */

import java.io.*;
import java.util.*;

public class ValidExpression {
    public static void main(String[] args) {
        String expr = "1+2";

        solve(expr);
    }
    
    public static void solve(String expr) {

    }

    public boolean isDigit(char c) {
        return c>='0' && c<='9';
    }

    public boolean isOperator(char c) {
        return c=='+' || c=='-';
    }
}
