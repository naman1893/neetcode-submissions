class Solution {
public:
     void dfs(vector<vector<int>>& visited, vector<vector<char>>& grid, int x, int y) {
        static const int dirs[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
        int n = grid.size(), m = grid[0].size();

        for (int k = 0; k < 4; ++k) {
            int dx = x + dirs[k][0];
            int dy = y + dirs[k][1];
            if (dx >= 0 && dy >= 0 && dx < n && dy < m &&
                !visited[dx][dy] && grid[dx][dy] == '1') {
                visited[dx][dy] = 1;
                dfs(visited, grid, dx, dy);
            }
        }
    }


    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>>visited(grid.size(),vector<int>(grid[0].size(),0));
        queue<pair<int,int>>q;
        int count=0;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    count++;
                    visited[i][j]=1;
                    dfs(visited,grid,i,j);
                }
            }
        }
        return count;
    }
};
