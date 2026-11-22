class Solution {
public:
    bool isSubsequence(string s, string t) {
        vector<vector<int>> ans(26);
        for (int i = 0; i < t.size(); i++) {
            ans[t[i] - 'a'].push_back(i + 1);
        }

        int prev_idx = 0; // Renamed from 't' to avoid shadowing parameter 't'
        int b = 0;

        for (int i = 0; i < s.size(); i++) {
            int k = s[i] - 'a';
            const vector<int>& demo = ans[k]; // Use reference to avoid copying
            
            for (int j = 0; j < demo.size(); j++) {
                if (demo[j] > prev_idx) {
                    prev_idx = demo[j]; // Store demo[j], not j
                    b++;                // Only increment 'b' when a valid match is found
                    break;
                }
            }
        }

        return b == s.size();
    }
};