15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(num==null || num.length<3) 
            return result;
        
        Arrays.sort(num);

        for(int i=0; i<num.length-2; i++) {
            if(i>0 && num[i]==num[i-1]) continue;

            int left = i+1;
            int right = num.length - 1;
            while(left<right) {
                int sum = num[left] + num[right];
                if(sum == -num[i]) {
                    List<Integer> r = new ArrayList<Integer>();
                    r.add(num[i]);
                    r.add(num[left]);
                    r.add(num[right]);
                    result.add(r);
                    left++;
                    right--;
                    while(left<right && num[left]==num[left-1]) left++;
                    while(right>left && num[right]==num[right+1]) right--;
                } else if(sum < -num[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
