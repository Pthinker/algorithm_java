163. Missing Ranges

Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();

        int l = lower;
        for (int i = 0; i <= nums.size(); ++i) {
            int r = (i < nums.length && nums[i] <= upper) ? nums[i] : upper + 1;
            if (l == r) {
            	++l;
            } else if (r > l) {
                res.add(r-l == 1 ? String.valueOf(l) : String.valueOf(l) + "->" + String.valueOf(r - 1));
                l = r + 1;
            }
        }
        
        return res;
    }
}