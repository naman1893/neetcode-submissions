class Solution {

    public void dfs(int[][] visited,int i,int j , char [][] grid, int n,int m ){
        if(i>=n||i<0||j>=m||j<0||grid[i][j]=='0'||visited[i][j]==1)
            return;
        else{
            visited[i][j]=1;
            dfs(visited,i+1,j,grid,n,m);
            dfs(visited,i,j+1,grid,n,m);
            dfs(visited,i,j-1,grid,n,m);
            dfs(visited,i-1,j,grid,n,m);
        }
    }

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int [][]visited = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0&&grid[i][j]=='1'){
                    dfs(visited,i,j,grid,n,m);
                    count++;
                }
            }
        }
        return count;
        
    }
}
