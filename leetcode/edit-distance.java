72. Edit Distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character


//https://discuss.leetcode.com/topic/3136/my-o-mn-time-and-o-n-space-solution-using-dp-with-explanation
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        //distance[i][j] is the distance converse word1(1~ith) to word2(1~jth)
        int[][] distance = new int[len1 + 1][len2 + 1]; 
        for (int j = 0; j <= len2; j++)
            {distance[0][j] = j;} //delete all characters in word2
        for (int i = 0; i <= len1; i++)
            {distance[i][0] = i;}
    
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { //ith & jth
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i][j - 1], distance[i - 1][j]), distance[i - 1][j - 1]) + 1;
                }
            }
        }
        return distance[len1][len2];        
    }
}

