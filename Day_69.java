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
