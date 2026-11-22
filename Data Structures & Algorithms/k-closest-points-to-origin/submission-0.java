class Solution {
    private static class Task {
        long distance;
        int[] point;
        Task(long distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.distance, b.distance)
        );

        for (int[] p : points) {
            long dist = (long)p[0] * p[0] + (long)p[1] * p[1];
            pq.add(new Task(dist, p));
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty() && i < k) {
            ans[i++] = pq.poll().point;
        }
        return ans;
    }
}
