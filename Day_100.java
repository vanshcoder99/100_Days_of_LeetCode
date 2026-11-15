// Set Rightmost Unset Bit
class Solution {
    public int setBit(int n) {
        return (n | n+1);
    }
}

// 419. Battleships in a Board
class Solution {
    public void dfshelper(int i,int j,char[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '.'){
            return;
        }
        grid[i][j] = '.';
        dfshelper(i-1,j,grid);
        dfshelper(i+1,j,grid);
        dfshelper(i,j+1,grid);
    }
    public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'X'){
                    cnt++;
                    dfshelper(i,j,board);
                }
            }
        }
        return cnt;
    }
}
