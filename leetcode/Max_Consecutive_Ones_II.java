487. Max Consecutive Ones II

Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you cannot store all numbers coming from the stream as it is too large to hold in memory. Could you solve it efficiently?


//http://www.cnblogs.com/Dylan-Java-NYC/p/6358630.html
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int zero = 0;
        int k = 1;
        
        for(int walker = 0, runner = 0; runner<nums.length; runner++){
            if(nums[runner] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[walker++] == 0){
                    zero--;
                }
            }
            res = Math.max(res, runner-walker+1);
        }

        return res;
    }
}


//////////////////////////////////////////

//follow up
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int k = 1;
        LinkedList<Integer> que = new LinkedList<Integer>();
        for(int walker = 0, runner = 0; runner<nums.length; runner++){
            if(nums[runner] == 0){
                que.offer(runner);
            }
            while(que.size()>k){
                walker = que.poll()+1;
            }
            res = Math.max(res, runner-walker+1);
        }
        return res;
    }
}
