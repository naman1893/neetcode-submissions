class Solution {
public:
    bool isAnagram(string s, string t) {

        unordered_map<char,int>st;
        for(char c:s){
            st[c]++;
        }
        for(char c:t){
            st[c]--;
        }
        for(auto num:st){
            if(num.second!=0)
                return false;
        }
        return true;
        
    }
};
