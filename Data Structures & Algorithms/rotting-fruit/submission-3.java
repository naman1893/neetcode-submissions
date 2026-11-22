class Solution {
    private static class Pair {
        int first, second, third;
        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> st = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 1;
                    st.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = -1;

        while (!st.isEmpty()) {
            int size = st.size();
            count++;
            while (size-- > 0) {
                Pair p = st.poll();
                for (int i = 0; i < 4; i++) {
                    int x = dx[i] + p.first;
                    int y = dy[i] + p.second;
                    if (x < n && x >= 0 && y < m && y >= 0 && visited[x][y] == 0 && grid[x][y] == 1) {
                        st.offer(new Pair(x, y, p.third + 1));
                        visited[x][y] = 1;
                    }
                }
            }
        }

        // Final check for any fresh orange that never got rotted
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    return -1;
                }
            }
        }
        return (count == -1) ? 0 : count;
    }
}
