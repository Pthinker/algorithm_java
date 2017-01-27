169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.


public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        
        for(int num : nums) {
            if(countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num)+1);
            } else {
                countMap.put(num, 1);
            }
        }
        
        int n=0;
        for(int num:nums) {
            if(countMap.get(num) > nums.length/2) {
                n=num;
                break;
            }
        }
        return n;
    }
}

///////////////////////////////////////////////////////////////////// 

public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num; 
                ++cnt;
            } else if (num == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }
}
