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
    bool static comparater(Interval a , Interval b){
        return a.start<b.start;
    }
    int minMeetingRooms(vector<Interval>& intervals) {
        sort(intervals.begin(),intervals.end(),comparater);
        priority_queue<int,vector<int>,greater<int>>pq;
        for(auto i:intervals){
            if(pq.size()!=0){
                if(pq.top()<=i.start){
                    pq.pop();
                }
            }
            pq.push(i.end);
        }
        return pq.size();

    }
};
