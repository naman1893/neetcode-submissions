class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans=0,max_value=0;
        for(int i=prices.size()-1;i>=0;i--){
            max_value=max(max_value,prices[i]);
            ans=max(max_value-prices[i],ans);
        }
        return ans;
    }
};
