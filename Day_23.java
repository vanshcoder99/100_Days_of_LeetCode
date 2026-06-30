// Number of Distinct Islands
class Solution {
    public void dfs(int r,int c,char[][] grid,List<List<Integer>> ans,int pr,int pc){
        int n = grid.length;
        int m = grid[0].length;
        grid[r][c] = 'W';
        ans.add(Arrays.asList(r-pr,c-pc));
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = r + delrow[i];
            int nc = c + delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 'L'){
                dfs(nr,nc,grid,ans,pr,pc);
            }
        }
    }
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<List<List<Integer>>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'L'){
                    List<List<Integer>> ans = new ArrayList<>();
                    dfs(i,j,grid,ans,i,j);
                    st.add(ans);
                }
            }
        }
        return st.size();
    }
}



// Detect Cycles in 2D Grid
class Solution {
    public boolean dfs(int r,int c,char[][] grid,boolean[][] vis,int pr,int pc) {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = true;
        char val = grid[r][c];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = r + delrow[i];
            int nc = c + delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == val && !vis[nr][nc]){
                if(dfs(nr,nc,grid,vis,r,c)) return true;
            }
            else if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] && grid[nr][nc] == val && (pr != -1 && pc != -1) && (pr != nr || pc != nc)){
                return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(dfs(i,j,grid,vis,-1,-1)) return true;
                }
            }
        }
        return false;
    }
}
