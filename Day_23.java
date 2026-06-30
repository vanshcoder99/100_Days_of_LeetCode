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
