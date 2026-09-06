//  Unique Paths II
class Solution {
    public int func(int i, int j,int[][] grid,int[][] dp) {
        if(i<0 || j<0 || grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = func(i-1,j,grid,dp) + func(i,j-1,grid,dp);
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(m-1,n-1,grid,dp);
    }
}




//Geek's Training
class Solution {
    public int func(int day,int last,int mat[][],int dp[][]) {
        if(day == 0){
            int maxi = 0;
            for(int i=0;i<3;i++){
                if(i != last){
                    maxi = Math.max(maxi,mat[0][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i != last){
                int sum = mat[day][i] + func(day-1,i,mat,dp);
                maxi = Math.max(maxi,sum);
            }
        }
        return dp[day][last] = maxi;
    }
    public int maximumPoints(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][4];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(m-1,3,mat,dp);
    }
}
