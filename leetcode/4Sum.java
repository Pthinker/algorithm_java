Given an array S of n integers, are there elements a, b, c, and d in S such 
that a + b + c + d = target? Find all unique quadruplets in the array which 
gives the sum of target.

Note:

Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
(ie, a ? b ? c ? d)
The solution set must not contain duplicate quadruplets.

For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)


public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);

        for(int i = 0; i < num.length; ++i) {
            for(int j = i + 1; j < num.length; ++j) {
                int low = j + 1;
                int high = num.length - 1;
                while(low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if(sum > target)
                        high--;
                    else if(sum < target)
                        low++;
                    else {
                        ArrayList<Integer> quadruplet = new ArrayList<Integer>();
                        quadruplet.add(num[i]);
                        quadruplet.add(num[j]);
                        quadruplet.add(num[low]);
                        quadruplet.add(num[high]);
                        if(!sol.contains(quadruplet))
                            sol.add(quadruplet);
                        low++;
                        high--;
                    }
                }
            }
        }
        return sol;
    }
}
