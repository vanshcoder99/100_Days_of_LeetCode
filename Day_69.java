// House Robber
class Solution {
    public int func(int n,int[] nums,int[] dp) {
        if(n<0) return 0;
        if(n == 0) return nums[0];
        if(dp[n] != -1) return dp[n];
        int sum1 = nums[n] + func(n-2,nums,dp);
        int sum2 = func(n-1,nums,dp);
        return dp[n] = Math.max(sum1,sum2);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(n-1,nums,dp);
    }
}


// Unique Paths
class Solution {
    public int func(int i, int j,int[][] dp) {
        if(i<0 || j<0) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = func(i-1,j,dp) + func(i,j-1,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(m-1,n-1,dp);
    }
}
