71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".


public class Solution {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] str = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String s : str) {
            if(s.equals("..")) {
                if(stack.size() != 0)
                    stack.pop();
            } else if(!s.equals(".") && !s.equals(""))
                stack.push(s);
        }
       
        while(stack.size()>0) {
            res.insert(0, stack.pop());
            if(stack.size() != 0)
                res.insert(0, "/");
        }
        res.insert(0, "/");
        return res.toString();
    }
}