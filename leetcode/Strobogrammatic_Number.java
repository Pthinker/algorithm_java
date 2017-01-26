359. Strobogrammatic Number

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.


public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        int lo = 0, hi = num.length() - 1;
        while (lo <= hi) {
            char loChar = num.charAt(lo);
            char hiChar = num.charAt(hi);
            if (!map.containsKey(loChar) || map.get(loChar) != hiChar) return false;
            lo++;
            hi--;
        }
        return true;
    }
}
