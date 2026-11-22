class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n=grid.size();int m = grid[0].size();
        queue<pair<int,int>>pq;
        vector<vector<int>>visited(grid.size(),vector<int>(grid[0].size(),0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    pq.push({i,j});
                    visited[i][j]=1;
                }
            }
        }
        int count=-1;
        while(pq.size()){
            int k=pq.size();
            while(k--){
                auto top = pq.front();
                pq.pop();
                int dx[4]={1,0,-1,0};
                int dy[4]={0,1,0,-1};
                for(int i=0;i<4;i++){
                    int x = dx[i]+top.first;
                    int y = dy[i]+top.second;
                    if(x>=0&&y>=0&&x<grid.size()&&y<grid[0].size()&&grid[x][y]==1&&visited[x][y]==0){
                        pq.push({x,y});
                        visited[x][y]=1;
                    }
                }
            }
            count++;
        }
        bool flag=true;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]==1&&visited[i][j]==0)
                    return -1;
                if(grid[i][j]==1||grid[i][j]==2)
                    flag=false;

            }
        }
        return flag==true?0:count;
    }
};
