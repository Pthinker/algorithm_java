163. Missing Ranges

Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]


//https://discuss.leetcode.com/topic/10681/my-concise-java-accepted-solution
public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int pre = lower - 1;
        for(int i = 0 ; i <= A.length; i++){
            int after = i == A.length ? upper + 1 : A[i]; 
            if(pre + 2 == after){
                result.add(String.valueOf(pre + 1));
            }else if(pre + 2 < after){
                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
            }
            pre = after;
        }
        return result;
    }
}

//////////////////////////////////////

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