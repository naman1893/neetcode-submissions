

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return true;

        // sort by start asc, and when equal, by end asc
        Collections.sort(intervals, (a, b) -> {
            if (a.start == b.start) return a.end - b.end;  // fixed tie-breaker
            else return a.start - b.start;
        });

        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval last = list.get(list.size() - 1);
            if (last.end > interval.start) {
                // overlap -> cannot attend all; keep your "skip adding" logic
                continue;
            } else {
                list.add(interval);
            }
        }

        // same final check, but boolean
        return list.size() == intervals.size();
    }
}
