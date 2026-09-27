// 213. House Robber II
class Solution {
    public int func(int i,int[] nums,int[] dp) {
        if(i < 0) return 0;
        if(i == 0) return nums[0];
        if(dp[i] != -1) return dp[i];
        int c1 = (int)-1e9, c2 = (int)-1e9;
        if(i>0) c1 = nums[i] + func(i-2,nums,dp);
        c2 = func(i-1,nums,dp);
        return dp[i] = Math.max(c1,c2);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n-1];
        Arrays.fill(dp,-1);
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];
        for(int i=0;i<n-1;i++){
            arr1[i] = nums[i];
            arr2[i] = nums[i+1];
        }
        int val1 = func(n-2,arr1,dp);
        Arrays.fill(dp,-1);
        int val2 = func(n-2,arr2,dp);
        return Math.max(val1,val2);
    }
}




// 1749. Maximum Absolute Sum of Any Subarray
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        int sum1 = 0,sum2 = 0;
        for(int i=0;i<n;i++){
            int val = nums[i];
            sum1+=val;
            sum2+=val;
            maxi = Math.max(sum1,maxi);
            mini = Math.min(sum2,mini);
            if(sum1<0) sum1 = 0;
            if(sum2>0) sum2 = 0;
        }
        mini = Math.abs(mini);
        return Math.max(maxi,mini);
    }
}
