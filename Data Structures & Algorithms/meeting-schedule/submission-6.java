/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return true;
        Collections.sort(intervals,(a,b)->{
            if(a.start==b.start)
                return a.end-b.end;
            else 
                return a.end-b.end;
        });
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            Interval last = list.get(list.size() - 1);
            if(last.end>interval.start)
                continue;
            else
            list.add(interval);
        }
        return(list.size()==intervals.size());
    }
}
