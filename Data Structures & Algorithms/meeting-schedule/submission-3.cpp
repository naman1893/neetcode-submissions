/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    bool canAttendMeetings(vector<Interval>& intervals) {
        vector<pair<int,int>>v;
        for(auto i:intervals){
            v.push_back({i.end,i.start});
        }
        if(intervals.size()==0) return true;
        sort(v.begin(),v.end());
        int end=v[0].first;
        for(int i=1;i<v.size();i++){
            if(v[i].second<end){
                return false;
            }
            end=v[i].first;
        }
        return true;
    }
};
