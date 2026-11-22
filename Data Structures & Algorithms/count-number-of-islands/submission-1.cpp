class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>>visited(grid.size(),vector<int>(grid[0].size(),0));
        queue<pair<int,int>>q;
        int count=0;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    count++;
                    q.push({i,j});
                    visited[i][j]=1;
                    while(q.size()){
                        auto top=q.front();
                        q.pop();
                        int dx[4]={1,0,-1,0};
                        int dy[4]={0,1,0,-1};
                        for(int k=0;k<4;k++){
                            int x = dx[k]+top.first;
                            int y = dy[k]+top.second;
                            if(x>=0&&y>=0&&x<grid.size()&&y<grid[0].size()&&visited[x][y]==0&&grid[x][y]=='1'){
                                q.push({x,y});
                                visited[x][y]=1;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
};
