288. Unique Word Abbreviation

An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word''s abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true


public class ValidWordAbbr {
    private Map<String, String> map = new HashMap<String, String>();

    public ValidWordAbbr(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++){
            String key = abbreviate(dictionary[i]);
            if(!map.containsKey(key)){
                map.put(key, dictionary[i]);
            }else{
                map.put(key, "");
            }
        }
    }
    
    private String abbreviate(String str){
        return str.charAt(0) + Integer.toString(str.length() - 2)+ str.charAt(str.length()-1);
    }

    public boolean isUnique(String word) {
        String x = abbreviate(word);
        if(map.containsKey(x)){
            if(map.get(x).equals(word)){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }
}