217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> data = new HashSet<Integer>();
        
        for(int num:nums) {
            if(data.contains(num)) {
                return true;
            } else {
                data.add(num);
            }
        }
        return false;
    }
}


