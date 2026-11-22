class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // Build adjacency list and indegree
        vector<vector<int>> adj(numCourses);
        vector<int> indegree(numCourses, 0);

        for (const auto& p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            adj[prereq].push_back(course);
            indegree[course]++;
        }

        // Start with all nodes that have indegree 0
        queue<int> q;
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) q.push(i);
        }

        int processed = 0;

        // Kahn's algorithm
        while (!q.empty()) {
            int u = q.front(); q.pop();
            processed++;

            for (int v : adj[u]) {
                if (--indegree[v] == 0) {
                    q.push(v);
                }
            }
        }

        return processed == numCourses;
    }
};
