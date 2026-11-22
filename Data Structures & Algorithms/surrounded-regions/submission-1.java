class Solution {
    private static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair>list = new LinkedList<>();
        int [][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if((i==0||j==0||i==board.length-1||j==board[0].length-1)&&board[i][j]=='O'){
                    list.add(new Pair(i,j));
                    visited[i][j]=1;
                }
            }
        }
        int dx[]={1,0,-1,0};
        int dy[]={0,1,0,-1};
        while(list.size()>0){
            Pair p =list.peek();
            list.poll();
            for(int i=0;i<4;i++){
                int x=p.x+dx[i];
                int y=p.y+dy[i];
                if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&visited[x][y]==0&&board[x][y]=='O'){
                    visited[x][y]=1;
                    list.add(new Pair(x,y));
                }
            }
        }
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){
                if(visited[i][j]==1)
                    board[i][j]='O';
                else 
                    board[i][j]='X';
            }
        }
        return;
    }
}
