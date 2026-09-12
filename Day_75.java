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




// Knapsack with Duplicate Items
class Solution {
    public int knapSack(int val[], int wt[], int W) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int w=1;w<=W;w++){
            dp[0][w] = w/wt[0] * val[0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=W;j++){
                int nottake = dp[i-1][j];
                int take = (int)-1e9;
                if(j>=wt[i]) take = val[i] + dp[i][j-wt[i]];
                dp[i][j] = Math.max(take,nottake); 
            }
        }   
        return dp[n-1][W];
    }
}
