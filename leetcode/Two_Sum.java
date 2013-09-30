Given an array of integers, find two numbers such that they add up to a specific 
target number.

The function twoSum should return indices of the two numbers such that they add 
up to the target, where index1 must be less than index2. Please note that your 
returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], i+1);
            } else if(2 * numbers[i] == target){
                result[0] = map.get(numbers[i]);
                result[1] = i + 1;
                return result;
            }            
        }

        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            if(numbers[i] + numbers[j] > target) {
                j--;
            } else if(numbers[i] + numbers[j] < target) {
                i++;
            } else {  
                result[0] = Math.min(map.get(numbers[i]), map.get(numbers[j]));
                result[1] = Math.max(map.get(numbers[i]), map.get(numbers[j]));             
                return result;
            }
        }   
        return result;
    }
}

////////////////////////////////////////////////////////////////

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<numbers.length; i++) {
            if(map.containsKey(numbers[i])) {
                if(numbers[i]*2 == target) {
                    res[0] = map.get(numbers[i])+1;
                    res[1] = i+1;
                    return res;
                }
            } else {
                map.put(numbers[i], i);
            }
        }

        for(int i=0; i<numbers.length; i++) {
            Integer t = map.get(target-numbers[i]);
            if(t!=null) {
                res[0] = i+1;
                res[1] = t+1;
                return res;
            }
        }
        return null;
    }
}

