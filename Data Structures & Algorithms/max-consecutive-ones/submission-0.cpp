class Solution {
   public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0)
                ans = 0;
            else {
                ans+=nums[i];
                nums[i]=ans;
            }
        }
        int maxi = 0;
        for (int i = 0; i < nums.size(); i++) {
            maxi = max(maxi, nums[i]);
        }
        return maxi;
    }
};