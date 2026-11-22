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
    bool static comparater(Interval a, Interval b){
        return a.end<b.end;
    }
    bool canAttendMeetings(vector<Interval>& intervals) {
        sort(intervals.begin(),intervals.end(),comparater);
        for(int i=0;i<intervals.size();i++){
            if(i!=intervals.size()-1&&intervals[i].end>intervals[i+1].start)
                return false;
        }
        return true;
    }
};
