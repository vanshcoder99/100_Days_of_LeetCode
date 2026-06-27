// Surrounded Regions
class Solution {
    public void dfs(int r, int c,char[][] board,boolean[][] vis){
        int n = board.length;
        int m = board[0].length;
        if(r<0 || r>=n || c < 0 || c>=m || board[r][c] != 'O' || vis[r][c]) return;
        vis[r][c] = true;
        dfs(r+1,c,board,vis);
        dfs(r-1,c,board,vis);
        dfs(r,c+1,board,vis);
        dfs(r,c-1,board,vis);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int j=0;j<m;j++){
            if(!vis[0][j] && board[0][j] == 'O'){
                dfs(0,j,board,vis);
            }
            if(!vis[n-1][j] && board[n-1][j] == 'O'){
                dfs(n-1,j,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,board,vis);
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }
}
