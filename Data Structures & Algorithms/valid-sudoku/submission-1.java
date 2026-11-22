
private static boolean checkRow(char[][] board,int x){
    HashSet<Character> hash = new HashSet<>();
    for(int i=0;i<board.length;i++){
        if(board[i][x]!='.'){
            if(hash.contains(board[i][x])){
                return false;
            }
            else {
                hash.add(board[i][x]);
            }
        }
    }
    return true;
}
private static boolean checkThreeByThreeBox(char[][] board,int x, int y){
    HashSet<Character> hash = new HashSet<>();
    for(int i=x;i<x+3;i++){
        for(int j=y;j<y+3;j++){
            if(board[i][j]!='.'){
                if(hash.contains(board[i][j])){
                    return false;
                }else
                    hash.add(board[i][j]);
            }
        }       
    }
    return true;
}

private static boolean checkColumn(char[][] board,int x){
    HashSet<Character> hash= new HashSet<>();
    for(int i=0;i<board[x].length;i++){
        if(board[x][i]!='.'){
            if(hash.contains(board[x][i])){
                return false;
            }else{
                hash.add(board[x][i]);
            }
        }
    }
    return true;
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(!checkRow(board,i)||!checkColumn(board,i))
                return false;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!checkThreeByThreeBox(board,i*3,j*3))
                    return false;
            }
        }
        return true;
    }
}
