12. Integer to Roman


Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


public class Solution {
    public String intToRoman(int num) {
        String[] oneLetters = {"I","X","C","M"};
        String[] fiveLetters = {"V","L","D",""};
        String numStr = num+"";
        String output = "";
        for(int i=numStr.length()-1; i>=0; i--) {
            String tmp = "";
            int bit = (int)num%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
            switch (bit){
                case 1: tmp = oneLetters[i];
                        break;
                case 2: tmp = oneLetters[i]+oneLetters[i];
                        break;
                case 3: tmp = oneLetters[i]+oneLetters[i]+oneLetters[i];
                        break;
                case 4: tmp = oneLetters[i]+fiveLetters[i];
                        break;
                case 5: tmp = fiveLetters[i];
                        break;
                case 6: tmp = fiveLetters[i]+oneLetters[i];
                        break;
                case 7: tmp = fiveLetters[i]+oneLetters[i]+oneLetters[i];
                        break;
                case 8: tmp = fiveLetters[i]+oneLetters[i]+oneLetters[i]+oneLetters[i];
                        break;
                case 9: tmp = oneLetters[i]+oneLetters[i+1];
                        break;
                default: tmp = "";
                        break;
            }
            output += tmp;
        }
        return output;
    }
}

///////////////

public class Solution {
    public String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digit=0;
        while (num > 0) {
            int times = num / nums[digit];
            num -= nums[digit] * times;
            for ( ; times > 0; times--) {
                res.append(symbols[digit]);
            }
            digit++;
        }
        return res.toString();
    }
}
