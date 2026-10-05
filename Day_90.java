// 312. Burst Balloons
class Solution {
    public int func(int i,int j,int[] nums,int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int steps = nums[i-1] * nums[ind] * nums[j+1] + func(i,ind-1,nums,dp) + func(ind+1,j,nums,dp);
            maxi = Math.max(maxi,steps);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++) arr[i+1] = nums[i];
        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<n+2;i++) Arrays.fill(dp[i],-1);
        return func(1,n,arr,dp);
    }
}
