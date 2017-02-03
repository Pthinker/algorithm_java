423. Reconstruct Original Digits from English

Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"


public class Solution {
    public String originalDigits(String s) {
        char chars[] = s.toCharArray();
        int n = s.length();
        int[] count = new int[10];
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c == 'z') count[0]++; //只有0有z
            else if (c == 'w') count[2]++; // 2 -> w
            else if (c == 'x') count[6]++; // 6 -> x
            else if (c == 'g') count[8]++; // 8-> g
            else if (c == 'u') count[4]++; // 4 -> u
            //上面是独有的，下面是可以计算出来的
            else if (c == 's') count[7]++; // 6/7 ->s
            else if (c == 'f') count[5]++; // 4/5 -> f
            else if (c == 'h') count[3]++; // 3/8 - > h
            else if (c == 'i') count[9]++; // 5/6/8/9 ->i
            else if (c == 'o') count[1]++; // 0/1/2/4 ->o
         }
         //计算
         count[7] -= count[6];
         count[5] -= count[4];
         count[3] -= count[8];
         count[9] = count[9] - count[8] - count[5] - count[6];
         count[1] = count[1] - count[0] - count[2] - count[4];
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
         }
         return sb.toString();
    }
}

///////////////////////////////
class Solution {
public:
    string originalDigits(string s) {
        string res = "";
        vector<int> counts(128, 0), nums(10, 0);
        for (char c : s) ++counts[c];
        nums[0] = counts['z'];
        nums[2] = counts['w'];
        nums[4] = counts['u'];
        nums[6] = counts['x'];
        nums[8] = counts['g'];
        nums[1] = counts['o'] - nums[0] - nums[2] - nums[4];
        nums[3] = counts['h'] - nums[8];
        nums[5] = counts['f'] - nums[4];
        nums[7] = counts['s'] - nums[6];
        nums[9] = counts['i'] - nums[6] - nums[8] - nums[5];
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums[i]; ++j) {
                res += (i + '0');
            }
        }
        return res;
    }
};
