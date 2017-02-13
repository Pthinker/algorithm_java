159. Longest Substring with At Most Two Distinct Characters

Given a string S, find the length of the longest substring T that contains at most two distinct characters.
For example,
Given S = “eceba”,
T is “ece” which its length is 3.


//哈希表记录每个字符的出现次数，然后如果哈希表中的映射数量超过两个的时候，我们需要删掉一个映射，比如此时哈希表中e有2个，c有1个，此时把b也存入了哈希表，那么就有三对映射了，这时我们的left是0，先从e开始，映射值减1，此时e还有1个，不删除，left自增1。这是哈希表里还有三对映射，此时left是1，那么到c了，映射值减1，此时e映射为0，将e从哈希表中删除，left自增1，然后我们更新结果为i - left + 1，以此类推直至遍历完整个字符串
int lengthOfLongestSubstringTwoDistinct(string s) {
    int res = 0, left = 0;
    unordered_map<char, int> m;
    for (int i = 0; i < s.size(); ++i) {
        ++m[s[i]];
        while (m.size() > 2) {
            if (--m[s[left]] == 0) m.erase(s[left]);
            ++left;
        }
        res = max(res, i - left + 1);
    }
    return res;
}
