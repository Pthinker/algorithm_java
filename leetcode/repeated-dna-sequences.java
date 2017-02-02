187. Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].


//https://segmentfault.com/a/1190000003922976
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int index = 10; index <= s.length(); index++){
            // 从第10位开始作为结尾，位移一位，比较一次子串
            String substr = s.substring(index - 10, index);
            if(map.containsKey(substr)){
                // 如果是第一次遇到，则加入结果
                if(map.get(substr) == 1){
                    res.add(substr);
                }
                // 标记为已经遇到过一次了
                map.put(substr, 2);
            } else {
                // 如果不存在，则加入表中
                map.put(substr, 1);
            }
        }
        return res;
    }
}

//////////////////////////

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int index = 10; index <= s.length(); index++){
            String substr = s.substring(index - 10, index);
            int code = encode(substr);
            if(map.containsKey(code)){
                if(map.get(code) == 1){
                    res.add(substr);
                }
                map.put(code, 2);
            } else {
                map.put(code, 1);
            }
        }
        return res;
    }
    
    private int encode(String str){
        int code = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // 每两位表示一个字符
            code <<= 2;
            switch(c){
                case 'A': code += 0; break;
                case 'C': code += 1; break;
                case 'T': code += 2; break;
                case 'G': code += 3; break;
            }
        }
        return code;
    }
}
