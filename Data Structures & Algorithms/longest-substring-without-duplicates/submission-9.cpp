class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<int>seti;
        int ans=0;
        int start=0,end=0;
        while(end<s.length()){
            while(seti.find(s[end])!=seti.end()){
                seti.erase(s[start]);
                start++;
            }
            seti.insert(s[end]);
            end++;
            ans=max(ans,end-start);
        }
        return ans;
    }
};
