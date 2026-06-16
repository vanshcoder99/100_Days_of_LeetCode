// Rotting Oranges
class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int bfs(Queue<Pair> q , int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int min = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                Pair p = q.poll();
                int row = p.first, col = p.second;
                for(int i=0;i<2;i++){
                    int nrow = (i%2==0) ? row + 1 : row - 1;
                    int ncol = (i%2==0) ? col + 1 : col - 1;
                    if(nrow >= 0 && nrow<n && grid[nrow][col] == 1){
                        grid[nrow][col] = 2;
                        q.offer(new Pair(nrow,col));
                    }
                    if(ncol>=0 && ncol < m && grid[row][ncol] == 1){
                        grid[row][ncol] = 2;
                        q.offer(new Pair(row,ncol));
                    }
                }
            }
            min++;
        }
        return min-1;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int freshes = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j] == 1){
                    freshes++;
                }
            }
        }
        if(freshes == 0) return 0;
        int min = bfs(q,grid);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return min;
    }
}
