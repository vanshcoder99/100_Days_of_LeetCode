// Number of Islands
class Pair{
    int first;
    int second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public void bfs(int r, int c, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        grid[r][c] = '0';
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            
            for(int i=0;i<2;i++){
                int nrow = (i%2==0) ? row+1 : row-1;
                int ncol = (i%2==0) ? col+1 : col-1;
                if(ncol>=0 && ncol<m  && grid[row][ncol] == '1'){
                    grid[row][ncol] = '0';
                    q.offer(new Pair(row,ncol));
                }
                if(nrow>=0 && nrow<n && grid[nrow][col] == '1'){
                    grid[nrow][col] = '0';
                    q.offer(new Pair(nrow,col));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,grid);
                }
            }
        }
        return cnt;
    }
}
