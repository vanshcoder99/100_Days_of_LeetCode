// Frog Jump
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int prev = 0, prev2 = 0;
        for(int i=1;i<n;i++){
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            left = prev + Math.abs(height[i]-height[i-1]);
            if(i>1) right = prev2 + Math.abs(height[i]-height[i-2]);
            int curri = Math.min(left,right);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}



// Stickler Thief
class Solution {
    public int func(int n, int[] nums,int[] dp){
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];
        int sum1 = 0, sum2 = 0;
        sum1+=nums[n];
        sum1+=func(n-2,nums,dp);
        sum2+=func(n-1,nums,dp);
        return dp[n]=Math.max(sum1,sum2);
    }
    public int findMaxSum(int nums[]) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(n-1,nums,dp);
    }
}
