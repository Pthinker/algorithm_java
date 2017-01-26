349. Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], true);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                set.add(nums2[j]);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int e : set) {
            result[i] = e;
            i++;
        }
        return result;
    }
}
