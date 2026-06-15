// Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int ans = 0, mini = prices[0];
        for(int i=1;i<n;i++){
            mini = Math.min(mini,prices[i]);
            if(mini<prices[i]){
                int net = prices[i] - mini;
                ans = Math.max(ans,net);
            }
        }
        return ans;
    }
}


// Find All Duplicates in an Array
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 1) return ans;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) ans.add(Math.abs(nums[i]));
            else nums[idx] = - nums[idx];
        }
        return ans;
    }
}


// Number of Enclaves
class Solution {
    public void dfs(int row, int col, int[] delrow, int[] delcol, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        grid[row][col] = 0;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,delrow,delcol,grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 1){
                    dfs(i,j,delrow,delcol,grid);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
