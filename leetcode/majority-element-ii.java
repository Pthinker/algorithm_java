229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

/*
观察可知，数组中至多可能会有2个出现次数超过 ⌊ n/3 ⌋ 的众数

记变量n1, n2为候选众数； c1, c2为它们对应的出现次数

遍历数组，记当前数字为num

若num与n1或n2相同，则将其对应的出现次数加1

否则，若c1或c2为0，则将其置为1，对应的候选众数置为num

否则，将c1与c2分别减1

最后，再统计一次候选众数在数组中出现的次数，若满足要求，则返回之。
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
 
        Integer n1=null, n2=null;
        int c1=0, c2=0;
     
        for(int i: nums){
            if(n1!=null && i==n1.intValue()){
                c1++;
            }else if(n2!=null && i==n2.intValue()){
                c2++;
            }else if(c1==0){
                c1=1;
                n1=i;
            }else if(c2==0){
                c2=1;
                n2=i;
            }else{
                c1--;
                c2--;
            }
        }
     
        c1=c2=0;
     
        for(int i: nums){
            if(i==n1.intValue()){
                c1++;
            }else if(i==n2.intValue()){
                c2++;
            }
        }
     
        if(c1>nums.length/3)
            result.add(n1);
        if(c2>nums.length/3)
            result.add(n2);
     
        return result;
    }
}
