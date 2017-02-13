135. Candy

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?


public class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];        
        Arrays.fill(candies, 1);// Give each child 1 candy 
        	
        for (int i = 1; i < candies.length; i++){// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
            if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
        }
         
        for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
    	    if (ratings[i] > ratings[i+1] && randies[i]<=candies[i+1]) {
    	        candies[i] = candies[i+1] + 1;
    	    }
        }
        
        int sum = 0;        
        for (int candy : candies)  
        	sum += candy;        
        return sum;
    }
}
