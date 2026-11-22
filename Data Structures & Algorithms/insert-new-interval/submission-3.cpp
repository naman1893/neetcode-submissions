class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>>ans;
        intervals.push_back(newInterval);
        sort(intervals.begin(),intervals.end());
        if(intervals.size()==1) return intervals;
        int j=0;
        ans.push_back(intervals[0]);
        for(int i=0;i<intervals.size();i++){
            if(intervals[i][0]<=ans[j][1]){
                ans[j][1]=max(ans[j][1],intervals[i][1]);
            }else {
                ans.push_back(intervals[i]);
                j++;
            }
        }
        return ans;

    }
};