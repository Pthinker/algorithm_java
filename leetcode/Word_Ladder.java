Given two words (start and end), and a dictionary, find the length of shortest 
transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


public class Solution {  
    public int ladderLength(String start, String end, HashSet<String> dict) {  
        Queue<String> queue = new LinkedList<String>();    
        Queue<Integer> length = new LinkedList<Integer>();    
        queue.add(start);    
        length.add(1);

        while(!queue.isEmpty()) {
            String word = queue.poll();  
            int len = length.poll();  
            if(canChange(word, end))  
                return len+1;
            
            char[] arr = word.toCharArray();
            for(int i=0; i<word.length(); i++) {
                char tmp = word.charAt(i);
                for(char c='a'; c<='z'; c++) {
                    if (tmp == c)  
                        continue;
                    arr[i] = c;
                    String str = String.valueOf(arr);
                    if (dict.contains(str)) {  
                        queue.add(str);
                        length.add(len+1);
                        dict.remove(str);
                    }  
                }
                arr[i] = tmp;
            }
        }  
        return 0;  
    }  
      
    public boolean canChange(String start, String stop) {    
        int diff = 0;
        for (int i=0; i<start.length(); i++) {
            if (start.charAt(i) != stop.charAt(i)) {    
                if (diff >= 1)
                    return false;    
                else    
                    diff++;  
            }
        }
        return true;    
    }
}  

