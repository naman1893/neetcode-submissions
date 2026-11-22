class Solution {
public:
    class DisjointSet {
    public:
        vector<int> parent, size;
        
        DisjointSet(int n) {
            parent.resize(n + 1);
            size.resize(n + 1, 1);  // Initialize size correctly
            
            for (int i = 0; i <= n; i++) {
                parent[i] = i; // Initialize parent array correctly
            }
        }

        int findUParent(int n) {
            if (parent[n] == n) return n;
            return parent[n] = findUParent(parent[n]); // Path compression
        }

        void UnionBySize(int u, int v) {
            int ul_u = findUParent(u);
            int ul_v = findUParent(v);
            
            if (ul_u == ul_v) return;

            if (size[ul_u] > size[ul_v]) {
                parent[ul_v] = ul_u;
                size[ul_u] += size[ul_v]; // Update the correct size
            } else {
                parent[ul_u] = ul_v;
                size[ul_v] += size[ul_u]; // Update the correct size
            }
        }
    };

    int countComponents(int n, vector<vector<int>>& edges) {
        DisjointSet d(n);  // No need for `n+1` since we already allocate `n+1`
        
        for (auto& edge : edges) {
            d.UnionBySize(edge[0], edge[1]);
        }

        unordered_set<int> seti;
        for (int i = 0; i < n; i++) {  
            seti.insert(d.findUParent(i)); // Use findUParent to get the true leader
        }

        return seti.size();
    }
};
