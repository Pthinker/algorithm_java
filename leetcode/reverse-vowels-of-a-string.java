345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".



public class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        Set<Character> vowerlSet = new HashSet<Character>();
        vowerlSet.add('a');
        vowerlSet.add('e');
        vowerlSet.add('i');
        vowerlSet.add('o');
        vowerlSet.add('u');
        vowerlSet.add('A');
        vowerlSet.add('E');
        vowerlSet.add('I');
        vowerlSet.add('O');
        vowerlSet.add('U');
        
        char[] arr = s.toCharArray();
        
        while(left<right) {
            if(vowerlSet.contains(arr[left]) && vowerlSet.contains(arr[right])) {
                char t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            } 
            
            if(!vowerlSet.contains(arr[left])){
                left++;
            }
            if(!vowerlSet.contains(arr[right])) {
                right--;
            }
        }
        
        return new String(arr);
    }
}
