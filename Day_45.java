// Climbing Stairs
class Solution {
    public int fibo(int n,int[] dp) {
        if(n == 1 || n == 0) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        return fibo(n+1,dp);
    }
}
