//  Partition Equal Subset Sum
class Solution {
    public boolean func(int i, int target, int[] nums, int[][] dp){
        if(target == 0) return true;
        if(i == 0) return nums[i] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean nottake = func(i-1,target,nums,dp);
        boolean take = false;
        if(target>=nums[i]) take = func(i-1,target-nums[i],nums,dp);
        dp[i][target] = take || nottake ? 1 : 0;
        return take || nottake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(n-1,target,nums,dp);
    }
}
