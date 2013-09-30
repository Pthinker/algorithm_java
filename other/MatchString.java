/* Given a string composed of 0, 1 and ?, ? can match 0 or 1, return all 
 * matching strings
 * http://www.mitbbs.com/article_t/JobHunting/32505211.html
 * http://www.mitbbs.com/article_t/JobHunting/32496747.html
 */

public class MatchString {
    public static void main(String[] args) {
        String str = "10?101?10";
        printMatch(str, 0, "");
    }

    public static void printMatch(String str, int index, String buffer) {
        if(index >= str.length()) {
            System.out.println(buffer);
            return;
        }
        
        if(str.charAt(index)=='1' || str.charAt(index)=='0')
            printMatch(str, index+1, buffer+str.charAt(index));
        else {
            printMatch(str, index+1, buffer+"0");
            printMatch(str, index+1, buffer+"1");
        }
    }
}
