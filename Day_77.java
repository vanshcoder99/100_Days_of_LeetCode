// 494. Target Sum
class Solution {
    public int func(int i,int target,int[] nums,int[][] dp) {
        if(i == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        if(dp[i][target] != -1) return dp[i][target];
        int nottake = func(i-1,target,nums,dp);
        int take = 0;
        if(target>=nums[i]) take = func(i-1,target-nums[i],nums,dp);
        return take + nottake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) sum+=nums[i];
        int s2 = sum - target;
        if(s2 < 0 || s2 % 2 == 1) return 0;
        s2 = s2/2;
        int[][] dp = new int[n][s2+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(n-1,s2,nums,dp);   
    }
}
