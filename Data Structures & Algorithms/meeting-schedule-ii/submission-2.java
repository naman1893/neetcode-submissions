class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        // time -> delta of rooms (+1 at start, -1 at end)
        TreeMap<Integer, Integer> delta = new TreeMap<>();

        for (Interval in : intervals) {
            delta.merge(in.start, 1, Integer::sum);
            delta.merge(in.end, -1, Integer::sum); // no +1; end is exclusive
        }

        int curr = 0, ans = 0;
        for (int change : delta.values()) {
            curr += change;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
