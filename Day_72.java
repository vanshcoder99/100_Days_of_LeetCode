// 1463. Cherry Pickup II
class Solution {
    public int func(int i,int j1,int j2,int[][] grid,int[][][] dp) {
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length) return (int) -1e5;
        if(i == grid.length-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi = -1;
        for(int dj1 = -1;dj1<=1;dj1++){
            for(int dj2 = -1;dj2<=1;dj2++){
                if(j1 == j2) maxi = Math.max(maxi,grid[i][j1] + func(i+1,j1+dj1,j2+dj2,grid,dp));
                else  maxi = Math.max(maxi,grid[i][j1] + grid[i][j2] + func(i+1,j1+dj1,j2+dj2,grid,dp));
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(0,0,n-1,grid,dp);
    }
}
